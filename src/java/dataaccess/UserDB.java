package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;

public class UserDB {

    public List<User> getAll(String owner) throws Exception {
        List<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user WHERE owner=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, owner);
            rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                Role role = rs.getString(4);
                User user = new User(email, first_name, last_name, role);
                users.add(user);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return users;
    }

    public User get(String email) throws Exception {
        User user = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE email=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, noteId);
            rs = ps.executeQuery();
            if (rs.next()) {
                String email = rs.getString(2);
                String first_name = rs.getString(3);
                String last_name = rs.getString(4);
                user = new User(email, first_name, last_name, role);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return user;
    }

    public void insert(Note note) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO note (title, contents, owner) VALUES (?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContents());
            ps.setString(3, note.getOwner());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void update(Note note) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE note SET title=?, contents=? WHERE note_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContents());
            ps.setInt(3, note.getNoteId());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void delete(Note note) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM note WHERE note_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, note.getNoteId());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

}
