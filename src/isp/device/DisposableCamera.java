package isp.device;

public class DisposableCamera implements PowerControllable {
    public void turnOn()  { System.out.println("Camera ON"); }
    public void turnOff() { System.out.println("Camera OFF"); }
}
