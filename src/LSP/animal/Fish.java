package LSP.animal;
public class Fish implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Fish makes blub-blub sound.");
    }
    // NO hay método walk(), Fish ni siquiera lo ve
}
