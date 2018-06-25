import java.util.*;

/**
 * Class in order to generate attribute for use with cards.
 * Represents an attribute.
 * @author Suhail Munshi
 * @version 1.0
 */
public class Attribute {

	protected int skillValue = 0;
	protected String Name = "No name";
	protected Player Parent = null;

	/**
	 * Class constructor. Creates an attribute with name and skill value provided.
	 * @param String name - Name of attribute
	 * @param int value - Skill value of attribute
	 */
	public Attribute(String name, int value) {
		//Constructor
		skillValue = value;
		Name = name;
	}

	/**
	 * This method returns the name and value of an attribute using a string s.
	 * @return String s
	 */
	protected String printA() {
		String s = (Name + " : " + skillValue);
		return s;
	}

	/**
	 * This method returns the numerical value of an attibute
	 * @return int skillValue
	 */
	protected int getValue() {
		return skillValue;
	}

}