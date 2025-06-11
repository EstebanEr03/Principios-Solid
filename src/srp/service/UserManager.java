package srp.service;

import srp.validator.UserValidator;
import srp.repository.UserRepository;
import srp.notification.NotificationService;

public class UserManager {
    private final UserValidator validator;
    private final UserRepository repository;
    private final NotificationService notifier;

    public UserManager(UserValidator validator,
                       UserRepository repository,
                       NotificationService notifier) {
        this.validator  = validator;
        this.repository = repository;
        this.notifier   = notifier;
    }

    public void addUser(String email, String password) {
        if (!validator.isValidEmail(email) || !validator.isValidPassword(password)) {
            System.out.println("Invalid email or password. User not added.");
            return;
        }
        repository.save(email, password);
        notifier.sendWelcomeMessage(email);
    }
}
