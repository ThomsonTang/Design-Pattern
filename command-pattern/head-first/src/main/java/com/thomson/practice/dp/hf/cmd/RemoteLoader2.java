package com.thomson.practice.dp.hf.cmd;

/**
 * the test for remote loader.
 *
 * @author Thomson Tang
 */
public class RemoteLoader2 {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        CeilingFan ceilingFan = new CeilingFan("Living Room");
        CeilingFanHighCommand highCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanLowCommand lowCommand = new CeilingFanLowCommand(ceilingFan);
        CeilingFanOffCommand offCommand = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(0, highCommand, offCommand);
        remoteControl.setCommand(1, lowCommand, offCommand);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

        remoteControl.onButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();

    }
}
