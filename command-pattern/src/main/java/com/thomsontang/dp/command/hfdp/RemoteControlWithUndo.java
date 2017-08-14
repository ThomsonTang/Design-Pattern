package com.thomsontang.dp.command.hfdp;

/**
 * the remote controller.
 *
 * @author Thomson Tang
 */
public class RemoteControlWithUndo {
    Command[] onCommands; //开的命令
    Command[] offCommands; //关的命令
    Command undoCommand;

    public RemoteControlWithUndo() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 5; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--------------Remote Controller----------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("slot[" + i + "]" + onCommands[i].getClass().getName()).append(" ").append(offCommands[i].getClass().getName()).append("\n");
        }
        return stringBuffer.toString();
    }
}
