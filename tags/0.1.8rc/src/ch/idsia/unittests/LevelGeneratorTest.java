package ch.idsia.unittests;

import ch.idsia.benchmark.mario.engine.level.Level;
import ch.idsia.benchmark.mario.engine.level.LevelGenerator;
import ch.idsia.benchmark.mario.engine.level.SpriteTemplate;
import ch.idsia.tools.CmdLineOptions;
import junit.framework.TestCase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey Karakovskiy, sergey.karakovskiy@gmail.com
 * Date: Aug 28, 2010
 * Time: 10:30:34 PM
 * Package: ch.idsia.unittests
 */
public class LevelGeneratorTest extends TestCase
{
    @BeforeTest
    public void setUp()
    {

    }

    @AfterTest
    public void tearDown()
    {

    }

    @Test
    public void testCreateLevel() throws Exception
    {
        final CmdLineOptions cmdLineOptions = new CmdLineOptions();
        Level level1 = LevelGenerator.createLevel(cmdLineOptions);
        Level level2 = LevelGenerator.createLevel(cmdLineOptions);

        for (int i = 0; i < level1.length; i++)
            for (int j = 0; j < level1.height; j++)
                assertEquals (level1.getBlock (i, j), level2.getBlock (i, j));
    }

    @Test
    public void testSpriteTemplates() throws Exception
    {
        final CmdLineOptions cmdLineOptions = new CmdLineOptions();
        Level level1 = LevelGenerator.createLevel(cmdLineOptions);
        Level level2 = LevelGenerator.createLevel(cmdLineOptions);

        for (int i = 0; i < level1.length; i++)
            for (int j = 0; j < level1.height; j++)
            {
                int t1 = 0;
                int t2 = 0;
                SpriteTemplate st1 = level1.getSpriteTemplate (i, j);
                SpriteTemplate st2 = level2.getSpriteTemplate (i, j);

                if (st1 != null)
                    t1 = st1.getType();

                if (st2 != null)
                {
                    t2 = st2.getType();
                } else if (st1 != null)
                {
                    throw new AssertionError("st1 is not null, st2 is null!");
                }

                assertEquals (t1, t2);
            }
    }
}
