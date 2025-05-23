package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    public List<User> allUsers = new ArrayList<User>();
    @Test
    void function() {
        allUsers.add(new User("user2", "p@ssw0rd2", "user2@mail.com"));
        allUsers.add(new User("user3", "p@ssw0rd3", "user3@mail.com"));
        RuntimeException ex = assertThrows(RuntimeException.class, () -> SILab2.function(null,allUsers));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", null, "thisUsersmail@mail.com"),allUsers));
        RuntimeException ex3 = assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", "P@ssw0rd!", null),allUsers));

        assertAll("Every Branch:",
                () -> assertTrue(ex.getMessage().contains("Mandatory information missing!")),
                () -> assertTrue(SILab2.function(new User("user1", "p@ssw0rd1", "user1@mail.com"), allUsers)),
                () -> assertFalse(SILab2.function(new User("user4","p@ssw0rd4","user4mail.com"), allUsers)),
                () -> assertFalse(SILab2.function(new User("user5","p@ss w0rd5","user5mail.com"), allUsers)),
                () -> assertFalse(SILab2.function(new User("user6","p@ss","user4mail.com"), allUsers))
        );
        assertAll("Multiple Conditions:",
                () -> assertTrue(ex.getMessage().contains("Mandatory information missing!")),
                () -> assertTrue(ex2.getMessage().contains("Mandatory information missing!")),
                () -> assertTrue(ex3.getMessage().contains("Mandatory information missing!"))
        );
    }
}