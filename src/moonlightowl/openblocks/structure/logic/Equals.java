package moonlightowl.openblocks.structure.logic;

import moonlightowl.openblocks.Assets;
import moonlightowl.openblocks.Blocks;
import moonlightowl.openblocks.io.lua.Binary;
import moonlightowl.openblocks.structure.Block;
import moonlightowl.openblocks.structure.Data;
import moonlightowl.openblocks.structure.Joint;

/**
 * OpenBlocks.Equals
 * Created by MoonlightOwl on 11/26/15.
 * ===
 * For great justice
 */

public class Equals extends Block {
    public Equals() {
        super(0, 0, Blocks.Id.EQUALS);
        addJoint(new Joint(this, -39, -2, Joint.TO, 0));
        addJoint(new Joint(this, 39, -2, Joint.TO, 1));
        addJoint(new Joint(this, 0, -42, Joint.FROM, Data.BOOLEAN, 2));
        addJoint(new Joint(this, 0, 39, Joint.VARIABLE, Data.BOOLEAN, 3).setMultiwired(true));
        setIcon(Assets.blockIconsIndex.get("equals.png"));
        operator = new Binary(" == ", null, null);
    }
}
