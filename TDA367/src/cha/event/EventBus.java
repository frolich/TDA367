package cha.event;


import java.util.LinkedList;
import java.util.List;

public class EventBus{

	private static EventBus CHinstance = null;
	private List<IEventHandler> handlers = new LinkedList<IEventHandler>();

		
	private EventBus(){
	}
	
	public static EventBus getInstance(){
		if(CHinstance == null){
			CHinstance = new EventBus();
		}
		return CHinstance;
	}
	
	public void register(IEventHandler handler){
		handlers.add(handler);
	}
	
	public void publish(Event e, Object o){
		for(IEventHandler h : handlers){
			h.action(e, o);
		}
	}
}