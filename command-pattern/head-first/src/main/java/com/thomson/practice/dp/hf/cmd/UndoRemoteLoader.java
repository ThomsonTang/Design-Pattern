package com.thomson.practice.dp.hf.cmd;

/**
 * the remote loader with undo operation.
 *
 * @author Thomson Tang
 */
public class UndoRemoteLoader {
    public static void main(String[] args) {
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

        Light livingRoomLight = new LivingRoomLight();
        LightOnCommand livingRoomOnCmd = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomOffCmd = new LightOffCommand(livingRoomLight);

        remoteControl.setCommand(0, livingRoomOnCmd,livingRoomOffCmd);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);

        remoteControl.undoButtonWasPushed();
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }
}
