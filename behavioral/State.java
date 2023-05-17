class State{
    public static void main(String[] args) {
        Monitor m1 = new Monitor();
        m1.turnOn();
        m1.inputFeed();
        m1.turnOn();
        m1.turnOff();
    }
}

class Monitor{
    private MonitorState state;
    public Monitor(){
        this.state = new OffState(this);
    }
    public void setState(MonitorState changedState){
        this.state = changedState;
    }
    public void turnOn(){
        this.state.handleOnEvent();
    }
    public void turnOff(){
        this.state.handleOffEvent();
    }
    public void inputFeed(){
        this.state.handleInputFeedEvent();
    }
}

interface MonitorState{
    void handleOnEvent();
    void handleOffEvent();
    void handleInputFeedEvent();
}

class OffState implements MonitorState{
    private Monitor monitor;
    public OffState(Monitor m){
        this.monitor = m;
    }
    public void handleOnEvent(){
        System.out.println("monitor turned on from off state");
        this.monitor.setState(new OnState(this.monitor));
    }
    public void handleOffEvent(){
        System.out.println("monitor is already in turned off state");
    }
    public void handleInputFeedEvent(){
        System.out.println("Turn on the monitor before feeding the input");
    }
}

class OnState implements MonitorState{
    private Monitor monitor;
    public OnState(Monitor m){
        this.monitor = m;
    }
    public void handleOnEvent(){
        System.out.println("monitor is already in turned on state");
    }
    public void handleOffEvent(){
        System.out.println("monitor turned off from on state");
        this.monitor.setState(new OffState(this.monitor));
    }
    public void handleInputFeedEvent(){
        System.out.println("monitor ready with feed after turning on");
        this.monitor.setState(new InputFeedState(this.monitor));
    }
}

class InputFeedState implements MonitorState{
    private Monitor monitor;
    public InputFeedState(Monitor m){
        this.monitor = m;
    }
    public void handleOnEvent(){
        System.out.println("monitor is already in turned on state with feed");
    }
    public void handleOffEvent(){
        System.out.println("monitor turned off from input feed state");
        this.monitor.setState(new OffState(this.monitor));
    }
    public void handleInputFeedEvent(){
        System.out.println("monitor is already in input feed state");
    }
}