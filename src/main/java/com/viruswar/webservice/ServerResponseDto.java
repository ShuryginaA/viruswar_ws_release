
package com.viruswar.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serverResponseDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serverResponseDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="command" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="info_turn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="command_coord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="num_commands" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="comm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serverResponseDto", propOrder = {
    "command",
    "infoTurn",
    "commandCoord",
    "numCommands",
    "comm",
    "status"
})
public class ServerResponseDto {

    protected String command;
    @XmlElement(name = "info_turn")
    protected String infoTurn;
    @XmlElement(name = "command_coord")
    protected String commandCoord;
    @XmlElement(name = "num_commands")
    protected int numCommands;
    protected String comm;
    protected String status;

    /**
     * Gets the value of the command property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommand() {
        return command;
    }

    /**
     * Sets the value of the command property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommand(String value) {
        this.command = value;
    }

    /**
     * Gets the value of the infoTurn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoTurn() {
        return infoTurn;
    }

    /**
     * Sets the value of the infoTurn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoTurn(String value) {
        this.infoTurn = value;
    }

    /**
     * Gets the value of the commandCoord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommandCoord() {
        return commandCoord;
    }

    /**
     * Sets the value of the commandCoord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommandCoord(String value) {
        this.commandCoord = value;
    }

    /**
     * Gets the value of the numCommands property.
     * 
     */
    public int getNumCommands() {
        return numCommands;
    }

    /**
     * Sets the value of the numCommands property.
     * 
     */
    public void setNumCommands(int value) {
        this.numCommands = value;
    }

    /**
     * Gets the value of the comm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComm() {
        return comm;
    }

    /**
     * Sets the value of the comm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComm(String value) {
        this.comm = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
