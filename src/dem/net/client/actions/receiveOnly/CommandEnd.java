package dem.net.client.actions.receiveOnly;

import dem.net.util.actions.Emitter;
import dem.net.util.actions.Receiver;
import dem.view.game.Deminator;

import java.util.List;

public class CommandEnd extends Receiver {
	public CommandEnd(Deminator d) {
		super(d);
	}

	@Override
	public void receive(List<String> params) {

	}
}