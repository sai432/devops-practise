package devops;

import devops.tasks.MyRunnableTasks;
import me.alb_i986.selenium.tinafw.tasks.runnable.RunnableTask;

import java.lang.reflect.InvocationTargetException;

/**
 * Provides a main for running RunnableTask's.
 * <p>
 * It may be used from the command line, by leveraging `mvn exec`.
 *
 * <pre>
 * {@code
 *     mvn clean compile exec:java -Dexec.args=runnableTaskMethodName
 * }
 * </pre>
 * where <code>runnableTaskMethodName</code> is one of the methods in {@link MyRunnableTasks}.
 */
public class TaskRunner {

	public static void main(String[] args) throws
			IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		if(args.length != 1) {
			System.err.println("Usage: " + TaskRunner.class.getSimpleName()
					+ " " + MyRunnableTasks.class.getSimpleName() + "_name");
			System.exit(1);
		}
		String runnableTaskName = args[0];
		RunnableTask task = ((RunnableTask) MyRunnableTasks.class
				.getMethod(runnableTaskName).invoke(null));
		task.run();
		System.exit(0);
	}

}
