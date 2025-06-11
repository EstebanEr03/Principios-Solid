class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }

    public void walk() {
        System.out.println("Animal is walking.");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}

class Fish extends Animal {
    @Override
    public void walk() {
        throw new UnsupportedOperationException("Fish can't walk.");
    }
}

