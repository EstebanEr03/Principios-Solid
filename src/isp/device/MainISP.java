package isp.device;

public class MainISP {
    public static void main(String[] args) {
        PowerControllable phone  = new Phone();
        PowerControllable camera = new DisposableCamera();

        phone.turnOn();
        ((Rechargeable) phone).charge();
        phone.turnOff();

        camera.turnOn();
        camera.turnOff();
        // No hay método charge() disponible para camera
    }
}