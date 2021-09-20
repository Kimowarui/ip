package duke.command;

import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

import java.time.LocalDate;

public class EventCommand extends Command {
    private final TaskList taskList;
    private final Ui textUi;
    private final String taskInfo;
    private final LocalDate taskTime;


    public EventCommand(TaskList taskList, Ui ui, String taskInfo, LocalDate time) {
        this.taskList = taskList;
        this.textUi = ui;
        this.taskInfo = taskInfo;
        this.taskTime = time;
    }

    @Override
    public String execute() {
        Task event = new Event(taskInfo, taskTime);
        taskList.add(event);
        return textUi.add(taskList, event);
    }

}

