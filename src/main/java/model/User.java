package model;

/**
 * Immutable data model for a system user.
 * roles  : TEACHER or STUDENT
 * status : PENDING (default on registration), ACTIVE, ...
 */
public record User(int id, String username, String password, String roles, String status) {
}
