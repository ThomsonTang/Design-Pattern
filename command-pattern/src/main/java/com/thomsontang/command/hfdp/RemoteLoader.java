package com.thomsontang.command.hfdp;

/**
 * the remote controller loader.
 *
 * @author Thomson Tang
 */
public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new LivingRoomLight();
        Light kitchenLight = new KitchenLight();
        GarageDoor garageDoor = new GarageDoor();

        //create all the light commands
        LightOnCommand livingRoomLightOnCmd = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOffCmd = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOnCmd = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOffCmd = new LightOffCommand(kitchenLight);

        // create all the door commands
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);

        remoteControl.setCommand(0, livingRoomLightOnCmd, livingRoomLightOffCmd);
        remoteControl.setCommand(1, kitchenLightOnCmd, kitchenLightOffCmd);
        remoteControl.setCommand(2, garageDoorOpenCommand, garageDoorDownCommand);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
    }
}
