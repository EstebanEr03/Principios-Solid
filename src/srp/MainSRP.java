package srp;

import srp.validator.UserValidator;
import srp.repository.UserRepository;
import srp.notification.EmailNotificationService;
import srp.service.UserManager;

public class MainSRP {
    public static void main(String[] args) {
        UserValidator validator   = new UserValidator();
        UserRepository repository = new UserRepository();
        EmailNotificationService notifier = new EmailNotificationService();

        UserManager userManager =
                new UserManager(validator, repository, notifier);

        // Pruebas
        userManager.addUser("example@domain.com", "password123");
        userManager.addUser("invalid-email", "1234");
    }
}
