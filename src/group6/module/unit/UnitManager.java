    package group6.module.unit;

    //import classes
    import group6.module.student.StudentUnitRecordManager;
    import group6.module.student.StudentUnitRecordList;
    import group6.IModule.IUnit;
    import group6.controller.XMLManager;
    import java.util.List;
    import org.jdom.*;

    /**
     * @author      Abdul Jawwad Patel
     * @version     1.0                 
     * Module Class  
     * It is used to handle course/subject details. Furthermore, it is used to evaluate 
     * student's grade.
     */


    // Create class UnitManager
    public class UnitManager {

            private static UnitManager self = null;

            private UnitMap UM;

            public static UnitManager UM() {
                    if (self == null)
                            self = new UnitManager();
                    return self;
            }

            private UnitManager() {
                    UM = new UnitMap();
            }

            public IUnit getUnit(String uc) {
                    IUnit iu = UM.get(uc);
                    return iu != null ? iu : createUnit(uc);

            }

            private IUnit createUnit(String unitCode) {

                    IUnit iu;
                    
                    //Run loop to iterate and get table attributs
                    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
                                    .getRootElement().getChild("unitTable").getChildren("unit"))
                            if (unitCode.equals(el.getAttributeValue("uid"))) {
                                    StudentUnitRecordList slist;

                                    slist = null;
                                    iu = new Unit(el.getAttributeValue("uid"),
                                                    el.getAttributeValue("name"), Float.valueOf(
                                                                    el.getAttributeValue("ps")).floatValue(), Float
                                                                    .valueOf(el.getAttributeValue("cr"))
                                                                    .floatValue(), Float.valueOf(
                                                                    el.getAttributeValue("di")).floatValue(), Float
                                                                    .valueOf(el.getAttributeValue("hd"))
                                                                    .floatValue(), Float.valueOf(
                                                                    el.getAttributeValue("ae")).floatValue(),
                                                    Integer.valueOf(el.getAttributeValue("asg1wgt"))
                                                                    .intValue(), Integer.valueOf(
                                                                    el.getAttributeValue("asg2wgt")).intValue(),
                                                    Integer.valueOf(el.getAttributeValue("examwgt"))
                                                                    .intValue(), StudentUnitRecordManager
                                                                    .instance().getRecordsByUnit(unitCode));
                                    UM.put(iu.getUnitCode(), iu);
                                    return iu;
                            }
                    
                    // Give message to user
                    throw new RuntimeException("DBMD: createUnit : unit not in file");
            }

            public UnitMap getUnits() {

                    UnitMap uM;
                    IUnit iu;

                    uM = new UnitMap();
                    for (Element el : (List<Element>) XMLManager.getXML().getDocument()
                                    .getRootElement().getChild("unitTable").getChildren("unit")) {
                            iu = new UnitProxy(el.getAttributeValue("uid"),
                                            el.getAttributeValue("name"));
                            uM.put(iu.getUnitCode(), iu);
                    } // unit maps are filled with PROXY units
                    return uM;
            }

    }
