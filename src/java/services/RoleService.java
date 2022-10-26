package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

public class RoleService {
    public Role get(int roleID) throws Exception {
        UserDB userDB = new UserDB();
        Role role = roleDB.get(roleID);
        return role;
    }
    
    public List<User> getAll(String email) throws Exception {
        UserDB userDB = new UserDB();
        List<User> notes = userDB.getAll(email);
        return notes;
    }
    
    public void insert(int roleID, String roleName) throws Exception {
        Role role = new Role(roleID, roleName);
        UserDB userDB = new UserDB();
        userDB.insert(role);
    }
    
    public void update(int noteId, String title, String contents, String owner) throws Exception {
        Note note = new Note(noteId, title, contents, owner);
        NoteDB noteDB = new NoteDB();
        noteDB.update(note);
    }
    
    public void delete(int roleID) throws Exception {
        Role role = new Role();
        role.setRoleId(roleID);
        UserDB userDB = new UserDB();
        userDB.delete(role);
    }
}
