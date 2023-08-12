package factory.definition;

import entity.definition.EntityDefinition;
import exception.DuplicateNameException;
import exception.NumberNotInRangeException;
import exception.PropertyTypeException;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import property.definition.PropertyDefinition;
import property.definition.range.Range;
import property.definition.value.PropertyDefinitionValue;
import schema.generated.*;
import termination.Termination;

import java.util.*;

public abstract class FactoryDefinition {
    private static PropertyDefinition createPropertyDefinition(PRDProperty prdProperty) {
        Range range = new Range(prdProperty.getPRDRange().getFrom(), prdProperty.getPRDRange().getTo());
        PropertyDefinitionValue value = new PropertyDefinitionValue(prdProperty.getPRDValue().isRandomInitialize(),prdProperty.getPRDValue().getInit());
        String type = new String(prdProperty.getType());
        String name = new String(prdProperty.getPRDName());

        if(!type.equals("decimal") && !type.equals("boolean") && !type.equals("float") && !type.equals("string")) {
            throw new PropertyTypeException("PropertyTypeException: " + prdProperty.getPRDName() + " type is not valid!" + " Problem occurred in class FactoryDefinition");
        }
        if(!value.isRandomInitialize()) {
            switch(type) {
                case "decimal":
                    try {
                        if(!isInRange(Integer.parseInt(value.getInit()), range)) {
                            throw new NumberNotInRangeException("NumberNotInRangeException: When trying to create property '" + prdProperty.getPRDName() + "'" +
                                    ". Please enter decimal number between " + range.getFrom() + " - " + range.getTo() + ". Problem occurred in class FactoryDefinition");
                        }
                    }
                    catch (NumberFormatException e) {
                        throw new NumberFormatException("NumberFormatException: When trying to create property '" + prdProperty.getPRDName() + "'" +
                                ". Please enter decimal number in init. Problem occurred in class FactoryDefinition");
                    }
                    break;

                case "float":
                    try {
                        if(!isInRange(Float.parseFloat(value.getInit()), range)) {
                            throw new NumberNotInRangeException("NumberNotInRangeException: When trying to create property '" + prdProperty.getPRDName() + "'" +
                                    ". Please enter float number between " + range.getFrom() + " - " + range.getTo() + ". Problem occurred in class FactoryDefinition");
                        }
                    }
                    catch (NumberFormatException e) {
                        throw new NumberFormatException( "NumberFormatException: When trying to create property '" + prdProperty.getPRDName() + "'" +
                                ". Please enter float number in init. Problem occurred in class FactoryDefinition");
                    }
                    break;

                case "boolean":
                        if(!value.getInit().equals("true") || !value.getInit().equals("false")) {
                            throw new IllegalArgumentException( "IllegalArgumentException: When trying to create property '" + prdProperty.getPRDName() + "'" +
                                    ". Please enter 'true' / 'false' in init. Problem occurred in class FactoryDefinition");
                        }
                    break;

                //case String - everything goes
            }
        }

        return new PropertyDefinition(name, type,value,range);
    }

    private static EntityDefinition createEntityDefinition(PRDEntity PRDEntity) {
        String name = new String(PRDEntity.getName());
        List<PRDProperty> PRDProperties = PRDEntity.getPRDProperties().getPRDProperty();
        Map<String, PropertyDefinition> properties = new HashMap<>();
        String duplicateName = FindDuplicateNamesForProp(PRDProperties);
        int population = PRDEntity.getPRDPopulation();

        if(duplicateName != null) {
            throw new DuplicateNameException("DuplicateNameException: the property name '" + duplicateName + "' in entity '" + name + "' show more then once.\n" +
                    "Note that every property in a single entity must have a unique name! Problem occurred in class FactoryDefinition");
        }

        PRDProperties.forEach(prdProperty -> properties.put(prdProperty.getPRDName(),createPropertyDefinition(prdProperty)));

        return new EntityDefinition(name, population ,properties);
    }

    public static Map<String, EntityDefinition> createEntitiesDefinition(PRDEntities prdEntities) {
        Map<String, EntityDefinition> res = new HashMap<>();
        List<PRDEntity> prdEntityList = prdEntities.getPRDEntity();
        String duplicateName = FindDuplicateNamesForEnt(prdEntityList);

        if(duplicateName != null) {
            throw new DuplicateNameException("DuplicateNameException: the entity name '" + duplicateName + "' show more then once.\n" +
                    "Note that every entity must have a unique name! Problem occurred in class FactoryDefinition");
        }
        prdEntityList.forEach(prdEntity -> res.put(prdEntity.getName(), createEntityDefinition(prdEntity)));

        return res;
    }

    private static PropertyDefinition createEnvironmentPropDefinition(PRDEnvProperty prdEnvProperty) {
        String type = new String(prdEnvProperty.getType());
        String name = new String(prdEnvProperty.getPRDName());
        Range range = new Range(prdEnvProperty.getPRDRange().getFrom(), prdEnvProperty.getPRDRange().getTo());

        if(!type.equals("decimal") && !type.equals("boolean") && !type.equals("float") && !type.equals("string")) {
            throw new PropertyTypeException("PropertyTypeException: " + name + " type is not valid!" + " Problem occurred in class FactoryDefinition");
        }

        return new PropertyDefinition(name, type, null, range);
    }

    public static Map<String, PropertyDefinition> createEnvironments(PRDEvironment prdEnvironment) {
        Map<String, PropertyDefinition> res = new HashMap<>();
        List<PRDEnvProperty> prdEnvironmentList = prdEnvironment.getPRDEnvProperty();
        String duplicateName = FindDuplicateNamesForEnvironment(prdEnvironmentList);

        if(duplicateName != null) {
            throw new DuplicateNameException("DuplicateNameException: the environment name '" + duplicateName + "' show more then once.\n" +
                    "Note that every environment must have a unique name! Problem occurred in class FactoryDefinition");
        }
        prdEnvironmentList.forEach(prdEnvProperty -> res.put(prdEnvProperty.getPRDName(),createEnvironmentPropDefinition(prdEnvProperty)));

        return res;
    }

    public static Termination createTermination(PRDTermination prdTermination){
        int seconds = 0, ticks = 0;

        if(prdTermination.getPRDByTicksOrPRDBySecond().size() == 1) {
            if(prdTermination.getPRDByTicksOrPRDBySecond().get(0) instanceof PRDBySecond){
                seconds = ((PRDBySecond)prdTermination.getPRDByTicksOrPRDBySecond().get(0)).getCount();
            } else {
                ticks = ((PRDByTicks)prdTermination.getPRDByTicksOrPRDBySecond().get(0)).getCount();
            }
        }
        else {
            if(prdTermination.getPRDByTicksOrPRDBySecond().get(0) instanceof PRDBySecond) {
                seconds = ((PRDBySecond)prdTermination.getPRDByTicksOrPRDBySecond().get(0)).getCount();
                ticks = ((PRDByTicks)prdTermination.getPRDByTicksOrPRDBySecond().get(1)).getCount();
            }
            else {
                ticks = ((PRDByTicks)prdTermination.getPRDByTicksOrPRDBySecond().get(0)).getCount();
                seconds = ((PRDBySecond)prdTermination.getPRDByTicksOrPRDBySecond().get(1)).getCount();
            }
        }
        return new Termination(ticks,seconds);
    }

    private static boolean isInRange(double numberToCheck, Range range) {
        if(range == null) {
            return true;
        }
        if(numberToCheck >= range.getFrom() && numberToCheck <= range.getTo()) {
            return true;
        }
        return false;
    }

    private static String FindDuplicateNamesForProp(List<PRDProperty> prdPropertyList) {
        Set<String> seenNames = new HashSet<>();

        for (PRDProperty prdProperty : prdPropertyList) {
            String name = prdProperty.getPRDName();
            if (seenNames.contains(name)) {
                return name;
            }
            seenNames.add(name);
        }

        return null;
    }

    private static String FindDuplicateNamesForEnt(List<PRDEntity> prdEntityList) {
        Set<String> seenNames = new HashSet<>();

        for (PRDEntity prdProperty : prdEntityList) {
            String name = prdProperty.getName();
            if (seenNames.contains(name)) {
                return name;
            }
            seenNames.add(name);
        }

        return null;
    }

    private static String FindDuplicateNamesForEnvironment(List<PRDEnvProperty> prdEnvPropertyList) {
        Set<String> seenNames = new HashSet<>();

        for (PRDEnvProperty prdEnvProperty : prdEnvPropertyList) {
            String name = prdEnvProperty.getPRDName();
            if (seenNames.contains(name)) {
                return name;
            }
            seenNames.add(name);
        }

        return null;
    }
}
