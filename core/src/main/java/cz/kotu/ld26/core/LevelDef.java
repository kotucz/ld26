package cz.kotu.ld26.core;

/**
 * @author Kotuc
 */
public abstract class LevelDef {

    static Level getLevel(int level) {
        switch (level) {
            case 1:
                return createFirstLevel();
            case 2:
                return createSecondLevel();
            default:
                return createErrorLevel();
        }
    }


    private static Level createFirstLevel() {
        return new Level() {
            public void init(PeaWorld world) {

                world.add(new Block(world, world.world, 1, 1, 2, 1, 0));

                world.add(new Block(world, world.world, 5, 5, 1, 1, 20));


                player = new Player(world, world.world, 3, 10, 0);
                world.add(player);

//        world.add(new Block(world, world.world, 5+5, 13, 15, 1, 0));

                world.createBlock(10, 2, 1, 5);

                world.createBlock(10, 2 + 5 + 1, 1, 5).setCollidable(false);

                world.createBlock(2, 13, 18 - 2, 1);

                Box spike = new Box(world, world.world, 3f + 15f, 1, 0);
                spike.setFallTime(5);
                world.add(spike);
            }
        };
    }

    private static Level createSecondLevel() {
        return new Level() {
            public void init(PeaWorld world) {

                world.add(new Block(world, world.world, 1, 1, 1, 1, 0));
                world.add(new Block(world, world.world, 0, 0, 1, 1, 0));

                world.add(new Block(world, world.world, 5, 5, 1, 1, 20));

                player = new Player(world, world.world, 3, 10, 0);
                world.add(player);

                world.add(new Block(world, world.world, 3, 12, 1, 1, 0));

                world.add(new Block(world, world.world, 3 + 8, 12, 3, 1, 0));

                world.add(new Block(world, world.world, 3f + 3f, 10, 3, 1, 0));

                world.add(new Block(world, world.world, 3f + 15f, 10, 3, 1, 0));

                Box spike = new Box(world, world.world, 3f + 15f, 1, 0);
                spike.setFallTime(5);

                world.add(spike);
            }
        };
    }

    private static Level createErrorLevel() {
        return new Level() {
            public void init(PeaWorld world) {

                player = new Player(world, world.world, 3, 10, 0);
                world.add(player);

                world.createBlock(10, 2, 1, 5);

                world.createBlock(11, 2, 3, 1);
                world.createBlock(11, 4, 2, 1);
                world.createBlock(11, 6, 3, 1);

                world.createBlock(10, 2 + 5 + 1, 1, 5).setCollidable(false);
                world.createBlock(2, 13, 18 - 2, 1);

                Box spike = new Box(world, world.world, 3f + 15f, 1, 0);
                spike.setFallTime(5);
                world.add(spike);
            }
        };
    }

}