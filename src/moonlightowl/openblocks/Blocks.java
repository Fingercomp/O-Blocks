package moonlightowl.openblocks;

import moonlightowl.openblocks.structure.Block;
import moonlightowl.openblocks.structure.robot.End;
import moonlightowl.openblocks.structure.robot.Start;
import java.util.function.Supplier;

/**
 * OpenBlocks.Blocks
 * Created by MoonlightOwl on 11/4/15.
 * ===
 * Index of all IDE blocks
 */
public class Blocks {
    /** Categories */
    public enum Category { ROBOT, ACTION, CYCLE, LOGIC }
    public enum Id {
        START(Category.ROBOT, "Начало", Start::new),
        END(Category.ROBOT, "Конец", End::new);

        public final int id;
        public final Category category;
        public final String name;
        private Supplier<Block> supplier;

        Id(Category category, String name, Supplier<Block> supplier){
            this.category = category; this.name = name; this.supplier = supplier;
            this.id = ordinal();
        }
        public Block getInstance(){ return supplier.get(); }
    }

//        all.put(MOVE, new Desc(MOVE, Category.ACTION, "Двигаться"));
//        all.put(DIG, new Desc(DIG, Category.ACTION, "Копать"));
//        all.put(BUILD, new Desc(BUILD, Category.ACTION, "Строить"));
//        all.put(SELECT_SLOT, new Desc(SELECT_SLOT, Category.ACTION, "Выбрать слот"));
//        all.put(WHILE, new Desc(WHILE, Category.CYCLE, "Повторять пока"));
//        all.put(FOR, new Desc(FOR, Category.CYCLE, "Повторить N раз"));
//        all.put(LOOP, new Desc(LOOP, Category.CYCLE, "Вечный цикл"));
//        all.put(IF, new Desc(IF, Category.LOGIC, "Если .. иначе"));
//        all.put(LESS, new Desc(LESS, Category.LOGIC, "Меньше"));
//        all.put(GREATER, new Desc(GREATER, Category.LOGIC, "Больше"));
//        all.put(EQUAL, new Desc(EQUAL, Category.LOGIC, "Равно"));
//        all.put(LESS_OR_EQUAL, new Desc(LESS_OR_EQUAL, Category.LOGIC, "Меньше или равно"));
//        all.put(GREATER_OR_EQUAL, new Desc(GREATER_OR_EQUAL, Category.LOGIC, "Больше или равно"));
//        all.put(NOT_EQUAL, new Desc(NOT_EQUAL, Category.LOGIC, "Не равно"));
//        all.put(NOT, new Desc(NOT, Category.LOGIC, "Не"));
}