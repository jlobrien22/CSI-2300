class Animal {
    public static void main(String[] args) {
        Animal myAnimal = new Animal(5, "Male");
        myAnimal.isMammal();
        myAnimal.mate();

        Fish myFish = new Fish(2, "Female", 3);
        myFish.canEat(); // Utilizing the canEat() method
        System.out.println("Fish size in feet: " + myFish.getSizeInFeet()); // Utilizing the sizeInFeet field

        Zebra myZebra = new Zebra(3, "Female", true);
        myZebra.run();
    }

    public int age;
    public String gender;

    public Animal(int age, String gender) {
        this.age = age;
        this.gender = gender;
    }

    public void isMammal() {
        System.out.println("This is a public method isMammal() from class Animal");
    }

    public void mate() {
        System.out.println("This is a public method mate() from class Animal");
    }
}

class Fish extends Animal {
    private int sizeInFeet;

    public Fish(int age, String gender, int sizeInFeet) {
        super(age, gender);
        this.sizeInFeet = sizeInFeet;
    }

    public void canEat() {
        System.out.println("This is a public method canEat() from class Fish");
    }

    public int getSizeInFeet() {
        return sizeInFeet;
    }
}

class Zebra extends Animal {
    public boolean is_wild;

    public Zebra(int age, String gender, boolean is_wild) {
        super(age, gender);
        this.is_wild = is_wild;
    }

    public void run() {
        System.out.println("This is a public method run() from class Zebra");
    }
}
