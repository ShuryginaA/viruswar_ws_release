
package com.viruswar.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for madeCommandsDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="madeCommandsDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="myMovesForClientCommandCoord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="myMovesForClientInfoTurn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="myMovesForClientCommand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "madeCommandsDto", propOrder = {
    "myMovesForClientCommandCoord",
    "myMovesForClientInfoTurn",
    "myMovesForClientCommand"
})
public class MadeCommandsDto {

    protected String myMovesForClientCommandCoord;
    protected String myMovesForClientInfoTurn;
    protected String myMovesForClientCommand;

    /**
     * Gets the value of the myMovesForClientCommandCoord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMyMovesForClientCommandCoord() {
        return myMovesForClientCommandCoord;
    }

    /**
     * Sets the value of the myMovesForClientCommandCoord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMyMovesForClientCommandCoord(String value) {
        this.myMovesForClientCommandCoord = value;
    }

    /**
     * Gets the value of the myMovesForClientInfoTurn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMyMovesForClientInfoTurn() {
        return myMovesForClientInfoTurn;
    }

    /**
     * Sets the value of the myMovesForClientInfoTurn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMyMovesForClientInfoTurn(String value) {
        this.myMovesForClientInfoTurn = value;
    }

    /**
     * Gets the value of the myMovesForClientCommand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMyMovesForClientCommand() {
        return myMovesForClientCommand;
    }

    /**
     * Sets the value of the myMovesForClientCommand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMyMovesForClientCommand(String value) {
        this.myMovesForClientCommand = value;
    }

}
