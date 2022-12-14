package pe.isil.ExamenFinalDESAI.auth;

public interface UserSecurityService {

    UserSecurity findUserSecurity(String email, String password);

    UserSecurity addUserSecurity(UserSecurity user);

    UserSecurity findUserSecurityEmail(String email);

}
