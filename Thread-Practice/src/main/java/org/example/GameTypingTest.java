package org.example;

public class GameTypingTest implements CharacterSource {
    protected RandomCharacterGenerator producer;
    private CharacterEventHandle handler;
    protected static char[] tmpChar = new char[1];



    @Override
    public void removeCharacterListener(CharacterListener cl) {
        handler.removeCharacterListener(cl);
    }

    @Override
    public void addCharacterListener(CharacterListener cl) {
        handler.addCharacterListener(cl);
    }

    @Override
    public void nextCharacter() {
        throw new IllegalStateException("We don't produce on demand");
    }
    public void newCharacter(int c) {
        handler.fireNewCharacter(this, c);
    }

//    public void setCharacterSource(CharacterSource source) {
//        source.addCharacterListener(this);
//    }

    public static void main(String[] args) {
        RandomCharacterGenerator producer = new RandomCharacterGenerator();
        GameTypingTest game = new GameTypingTest();

        //game.setCharacterSource(producer); //
        producer.start();
    }


}
