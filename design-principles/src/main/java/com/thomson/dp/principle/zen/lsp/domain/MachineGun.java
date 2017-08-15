package com.thomson.dp.principle.zen.lsp.domain;

public class MachineGun extends AbstractGun {
    @Override public void shoot() {
        System.out.println("机枪扫射.......");
    }

    @Override public void setShape(String color) {
        super.setShape("机枪的形状");
    }
}
