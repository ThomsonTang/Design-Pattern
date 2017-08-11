package com.thomsontang.command.hfdp;

/**
 * the simple remote controller.
 *
 * @author Thomson Tang
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    /**
     * press the button of the remote controller.
     */
    public void buttonWasPressed() {
        slot.execute();
    }

    public void setCommand(Command slot) {
        this.slot = slot;
    }
}
