package group6.controller;

import group6.module.unit.UnitManager;
import group6.module.unit.UnitMap;
import group6.IModule.IUnitLister;

public class ListUnitsCTL {
    private UnitManager um;
    public ListUnitsCTL() {
        um = UnitManager.UM();
    }
    public void listUnits( IUnitLister lister ) {
        lister.clearUnits();
        UnitMap units = um.getUnits();
        for (String s : units.keySet() )
            lister.addUnit(units.get(s));}}
