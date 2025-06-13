package isp.device.broken;

interface Device {
    void turnOn();
    void turnOff();
    void charge();
}

class Phone implements Device {
    public void turnOn()  { System.out.println("Phone ON"); }
    public void turnOff() { System.out.println("Phone OFF"); }
    public void charge()  { System.out.println("Phone charging"); }
}

class DisposableCamera implements Device {
    public void turnOn()  { System.out.println("Camera ON"); }
    public void turnOff() { System.out.println("Camera OFF"); }
    public void charge()  {
        throw new UnsupportedOperationException("Cameras cannot be charged");
    }
}

public class MainISP_Broken {
    public static void main(String[] args) {
        Device phone  = new Phone();
        Device camera = new DisposableCamera();

        phone.turnOn();
        phone.charge();

        camera.turnOn();
        camera.charge();       // ← lanzará la excepción
    }
}
