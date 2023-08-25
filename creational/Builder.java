class Builder{
    public static void main(String[] args) {
        Phone p = new Phone("Android", 4, 3000, 5.5, 128);
        p.printPhone();

        //Building phone object using builder
        Phone p2 = new PhoneBuilder().setOs("IOS").setRam(8).getPhone();
        p2.printPhone();

    }
}

class Phone{
    private String os;
    private int ram;
    private int battery;
    private double screenSize;
    private int rom;

    public Phone(String os, int ram, int battery, double screenSize, int rom){
        this.os = os;
        this.battery = battery;
        this.ram = ram;
        this.screenSize = screenSize;
        this.rom = rom;
    }
    public void printPhone(){
        System.out.println("Phone - [ os = "+this.os+" , ram = "+Integer.toString(this.ram)+" , battery = "+
        Integer.toString(this.battery)+" , screen size = "+String.valueOf(this.screenSize)+" , rom = "+Integer.toString(this.rom)+" ]");
    }
}

class PhoneBuilder{
    private String os;
    private int ram;
    private int battery;
    private double screenSize;
    private int rom;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }
    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }
    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }
    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }
    public PhoneBuilder setRom(int rom) {
        this.rom = rom;
        return this;
    }

    public Phone getPhone(){
        return new Phone(os, ram, battery, screenSize, rom);
    }
}