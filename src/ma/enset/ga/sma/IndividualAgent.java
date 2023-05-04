package ma.enset.ga.sma;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

import java.util.Random;
public class IndividualAgent extends Agent {
    String individual;
    private int fitness;
    private final String target = "Bonjour";
    private final String GENES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    private final Random rnd = new Random();

    protected void setup() {
        // Initialize genes randomly

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            sb.append(GENES.charAt(rnd.nextInt(GENES.length())));
        }
        individual = sb.toString();
        // Calculate the fitness
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                fitness = 0;
                for (int i = 0; i < target.length(); i++) {
                    if (individual.charAt(i) == target.charAt(i)) {
                        fitness++;
                    }
                }
            }
        });
        AgentContainer containerController = getContainerController();
        try {
            containerController.createNewAgent("GAPopulation","ma.enset.sma.GAPopulationAgent",new Object[]{});
        } catch (StaleProxyException e) {
            throw new RuntimeException(e);
        }

        // Mutation
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                int index = rnd.nextInt(target.length());
                StringBuilder sb = new StringBuilder(individual);
                char c = GENES.charAt(rnd.nextInt(GENES.length()));
                sb.setCharAt(index, c);
                individual = sb.toString();
            }
        });
    }
}
