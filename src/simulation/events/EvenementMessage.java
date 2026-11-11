package simulation.events;

public class EvenementMessage extends Evenement {
    private String message;
    public EvenementMessage(long date, String messageString){
        super(date);
        this.message = messageString;
    }

    public EvenementMessage(long date){
        this(date, "Evenement de type Message declenche.");
    }
    
    @Override
    public void execute() {
        System.out.println(this.message);
    }
}
