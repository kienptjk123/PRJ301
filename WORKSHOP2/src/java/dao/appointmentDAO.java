/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AppointmentDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author adm
 */
public class appointmentDAO {
    public List<AppointmentDTO> getAllAppoinment(){
        String sql = "SELECT * FROM APPOINTMENTS ORDER by appointmentID";
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<AppointmentDTO> appointments = new ArrayList<>();
            while (rs.next()) {
                AppointmentDTO appointment = AppointmentDTO.builder()
                        .id(rs.getInt("appointmentID"))
                        .userId(rs.getInt("userID"))
                        .appointmentDate(rs.getString("appointmentDate"))
                        .appointmentTime(rs.getString("appointmentTime"))
                        .purpose(rs.getString("purpose"))
                        .status(rs.getString("status"))
                        .build();
                appointments.add(appointment);
            }
            return appointments;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<AppointmentDTO> getAllAppoinmentScheduled(int id){
        String sql = "SELECT * FROM APPOINTMENTS WHERE userID=? AND status = 'Scheduled' ";
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            List<AppointmentDTO> appointments = new ArrayList<>();
            while (rs.next()) {
                AppointmentDTO appointment = AppointmentDTO.builder()
                        .id(rs.getInt("appointmentID"))
                        .userId(rs.getInt("userID"))
                        .appointmentDate(rs.getString("appointmentDate"))
                        .appointmentTime(rs.getString("appointmentTime"))
                        .purpose(rs.getString("purpose"))
                        .status(rs.getString("status"))
                        .build();
                appointments.add(appointment);
            }
            return appointments;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<AppointmentDTO> getAllAppoinmentCompleted(int id){
        String sql = "SELECT * FROM APPOINTMENTS WHERE userID=? AND status = 'Completed' ";
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            List<AppointmentDTO> appointments = new ArrayList<>();
            while (rs.next()) {
                AppointmentDTO appointment = AppointmentDTO.builder()
                        .id(rs.getInt("appointmentID"))
                        .userId(rs.getInt("userID"))
                        .appointmentDate(rs.getString("appointmentDate"))
                        .appointmentTime(rs.getString("appointmentTime"))
                        .purpose(rs.getString("purpose"))
                        .status(rs.getString("status"))
                        .build();
                appointments.add(appointment);
            }
            return appointments;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<AppointmentDTO> getAllAppoinmentByUserID(int id){
        String sql = "SELECT * FROM APPOINTMENTS WHERE userID=?";
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            List<AppointmentDTO> appointments = new ArrayList<>();
            while (rs.next()) {
                AppointmentDTO appointment = AppointmentDTO.builder()
                        .id(rs.getInt("appointmentID"))
                        .userId(rs.getInt("userID"))
                        .appointmentDate(rs.getString("appointmentDate"))
                        .appointmentTime(rs.getString("appointmentTime"))
                        .purpose(rs.getString("purpose"))
                        .status(rs.getString("status"))
                        .build();
                appointments.add(appointment);
            }
            return appointments;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public AppointmentDTO getAppoinmentByID(int appointmentID){
        String sql = "SELECT * FROM APPOINTMENTS WHERE appointmentID = ?";
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, appointmentID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AppointmentDTO appointment = AppointmentDTO.builder()
                        .id(rs.getInt("appointmentID"))
                        .userId(rs.getInt("userID"))
                        .appointmentDate(rs.getString("appointmentDate"))
                        .appointmentTime(rs.getString("appointmentTime"))
                        .purpose(rs.getString("purpose"))
                        .status(rs.getString("status"))
                        .build();
                return appointment;
            }
            return null;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean addAppointment( AppointmentDTO appointment){
        String sql = "INSERT INTO APPOINTMENTS(userID ,appointmentDate, appointmentTime, purpose, status)"
                + "VALUES(?,?,?,?,?)";
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, appointment.getUserId());
            preparedStatement.setString(2, appointment.getAppointmentDate());
            preparedStatement.setString(3, appointment.getAppointmentTime());
            preparedStatement.setString(4,appointment.getPurpose());
            preparedStatement.setString(5, appointment.getStatus());
            return preparedStatement.executeUpdate() > 0;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateAppointment(AppointmentDTO appointment){
        String sql = "UPDATE APPOINTMENTS SET appointmentDate = ?, appointmentTime=?, purpose=?, status=? WHERE appointmentID = ? ";
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,appointment.getAppointmentDate());
            preparedStatement.setString(2,appointment.getAppointmentTime());
            preparedStatement.setString(3,appointment.getPurpose());
            preparedStatement.setString(4, appointment.getStatus());
            preparedStatement.setInt(5, appointment.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<AppointmentDTO> getAppointmentByDate(Date startDate, Date endDate){
        String sql = "SELECT * FROM APPOINTMENTS WHERE appointmentDate BETWEEN ? AND ?";
        try {
            Connection connection = DBUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1,startDate );
            preparedStatement.setDate(2, endDate);
            ResultSet rs = preparedStatement.executeQuery();
            List<AppointmentDTO> appointments = new ArrayList<>();
            
            while(rs.next()){
                AppointmentDTO appointment = AppointmentDTO.builder()
                        .id(rs.getInt("appointmentID"))
                        .userId(rs.getInt("userID"))
                        .appointmentDate(rs.getString("appointmentDate"))
                        .appointmentTime(rs.getString("appointmentTime"))
                        .purpose(rs.getString("purpose"))
                        .status(rs.getString("status"))
                        .build();
                appointments.add(appointment);
            }
            return appointments;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     
    
}
