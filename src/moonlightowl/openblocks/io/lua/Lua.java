package moonlightowl.openblocks.io.lua;

import moonlightowl.openblocks.Workspace;
import moonlightowl.openblocks.structure.Block;
import moonlightowl.openblocks.structure.Joint;

import java.io.IOException;
import java.io.OutputStream;

import static moonlightowl.openblocks.Blocks.Id.END;
import static moonlightowl.openblocks.Blocks.Id.START;

/**
 * OpenBlocks.Lua
 * Created by MoonlightOwl on 11/13/15.
 * ===
 * Core export module
 */

public class Lua {
    public static boolean export(Workspace workspace, OutputStream stream) throws IOException {
        // Let's get started - search for Start block
        for(Block block: workspace.getBlocks())
            if(block.getBlockId() == START)
                return new Tracer(block, stream).run();
        return false;
    }

    private static class Tracer {
        private Block current;
        private OutputStream stream;

        public Tracer(Block beginFrom, OutputStream stream){
            this.current = beginFrom;
            this.stream = stream;
        }
        public boolean run() throws IOException {
            while(current != null){
                if(current.getBlockId() == END) break;
                switch(current.getBlockId()){
                    case START:
                        stream.write("local robot = require('robot')\n".getBytes()); break;
                    case MOVE:
                        stream.write("robot.forward()\n".getBytes()); break;
                }
                Block block = null;
                for(Joint joint: current.getJoints()){
                    if(joint.getType() == Joint.FROM){
                        Joint next = joint.getLink();
                        if(next != null){
                            block = next.getOwner(); break;
                        }
                    }
                }
                current = block;
            }
            return true;
        }
    }
}