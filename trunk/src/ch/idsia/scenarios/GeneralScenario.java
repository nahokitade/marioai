package ch.idsia.scenarios;

import ch.idsia.ai.agents.Agent;
import ch.idsia.ai.agents.ai.ForwardAgent;
import ch.idsia.maibe.experiments.EpisodicExperiment;
import ch.idsia.maibe.experiments.Experiment;
import ch.idsia.maibe.tasks.ProgressTask;
import ch.idsia.maibe.tasks.Task;
import ch.idsia.tools.CmdLineOptions;
import ch.idsia.tools.EvaluationOptions;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy, sergey at idsia dot ch
 * Date: Feb 24, 2010
 * Time: 12:57:18 PM
 * Package: ch.idsia.scenarios
 */
public class GeneralScenario
{
    public static void main(String[] args)
    {
//        Agent agent = new ForwardAgent();
        CmdLineOptions options = new CmdLineOptions(args);
        Task task = new ProgressTask(options);
        Experiment exp = new EpisodicExperiment(task, options.getAgent());
        exp.doEpisodes(2);
    }
}
