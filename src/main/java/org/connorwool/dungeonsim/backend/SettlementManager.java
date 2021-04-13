package org.connorwool.dungeonsim.backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Responsible for maintaining a collection of settlements
 */
public class SettlementManager {

    private static final String savefile = "Settlements.dsf";
    private final List<Settlement> settlementList = new ArrayList<>();

    public void addSettlement(Settlement s) {
        this.settlementList.add(s);
    }

    public Settlement removeSettlement(Settlement s) {
        return null;
    }

    public Optional<Exception> saveSettlements() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(
                savefile); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            for (Settlement s : settlementList) {
                objectOutputStream.writeObject(s);
            }
            objectOutputStream.flush();
        } catch (IOException e) {
            return Optional.of(e);
        }
        return Optional.empty();
    }

    public Optional<Exception> loadSettlements() {
        try (FileInputStream fileInputStream = new FileInputStream(
                savefile); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            while (objectInputStream.available() > 0) {
                settlementList.add((Settlement) objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            return Optional.of(e);
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "SettlementManager{" + "settlementList=" + settlementList + '}';
    }
}
