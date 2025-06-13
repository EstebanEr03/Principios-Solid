package isp.device;

public class Phone implements PowerControllable, Rechargeable {
    public void turnOn()  { System.out.println("Phone ON"); }
    public void turnOff() { System.out.println("Phone OFF"); }
    public void charge()  { System.out.println("Phone charging"); }
}
