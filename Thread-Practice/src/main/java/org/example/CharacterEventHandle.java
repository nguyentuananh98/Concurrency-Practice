package org.example;

import java.util.Vector;

public class CharacterEventHandle {
    private Vector listeners = new Vector();

    public void addCharacterListener(CharacterListener l) {
        listeners.add(l);
    }

    public void removeCharacterListener(CharacterListener l) {
        listeners.remove(l);
    }
    public void fireNewCharacter(CharacterSource source, int c) {
        CharacterEvent ce = new CharacterEvent(source, c);
        CharacterListener[] cl = (CharacterListener[]) listeners.toArray(new CharacterListener[0]);
        for (int i = 0; i < cl.length; i++) {
            cl[i].newCharacter(ce);
        }
    }
}
