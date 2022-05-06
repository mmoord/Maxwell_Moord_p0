package com.revature.Maxwell_Moord_p0.menus;

import java.util.*;

public abstract class Menu {

    protected Scanner kb = new Scanner(System.in);

    public Menu(Scanner kb) {
        super();
        this.kb = kb;

    }

    public abstract void render() throws Exception;

}
