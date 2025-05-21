package org.example;

import java.util.Random;

public class RandomCharacterGenerator extends Thread implements CharacterSource{
    static char[] chars;
    static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";
    static {
        chars = charArray.toCharArray();
    }

    Random rand;
    CharacterEventHandle handle;

    public RandomCharacterGenerator() {
        rand = new Random();
        handle = new CharacterEventHandle();
    }
    public int getPauseTime() {
        return (int) (Math.max(1000, 5000 * rand.nextDouble( )));
    }

    @Override
    public void addCharacterListener(CharacterListener cl) {
        handle.addCharacterListener(cl);
    }

    @Override
    public void removeCharacterListener(CharacterListener cl) {
        handle.removeCharacterListener(cl);
    }

    @Override
    public void nextCharacter() {
        handle.fireNewCharacter(this,
                (int) chars[rand.nextInt(chars.length)]);
    }

    @Override
    public void run() {
        for (;;){
            nextCharacter();
            try {
                Thread.sleep(getPauseTime());
            }catch (InterruptedException e) {
                return;
            }
        }
        //super.run();
    }
}
