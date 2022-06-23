
package ukr.astelit.idr.rtn.ws.api.chain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for generalResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="generalResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="buildVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="invokationTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="resultCode" type="{http://chain.api.ws.rtn.idr.astelit.ukr/}resultCodeType" minOccurs="0"/>
 *         &lt;element name="resultDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generalResult", propOrder = {
    "buildVersion",
    "error",
    "invokationTime",
    "resultCode",
    "resultDescription",
    "transactionId"
})
@XmlSeeAlso({
    ChainSignatureResult.class,
    ChainResult.class,
    ChainsListResult.class
})
public class GeneralResult {

    protected String buildVersion;
    protected String error;
    protected long invokationTime;
    @XmlSchemaType(name = "string")
    protected ResultCodeType resultCode;
    protected String resultDescription;
    protected Object transactionId;

    /**
     * Gets the value of the buildVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildVersion() {
        return buildVersion;
    }

    /**
     * Sets the value of the buildVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildVersion(String value) {
        this.buildVersion = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setError(String value) {
        this.error = value;
    }

    /**
     * Gets the value of the invokationTime property.
     * 
     */
    public long getInvokationTime() {
        return invokationTime;
    }

    /**
     * Sets the value of the invokationTime property.
     * 
     */
    public void setInvokationTime(long value) {
        this.invokationTime = value;
    }

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResultCodeType }
     *     
     */
    public ResultCodeType getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultCodeType }
     *     
     */
    public void setResultCode(ResultCodeType value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the resultDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultDescription() {
        return resultDescription;
    }

    /**
     * Sets the value of the resultDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultDescription(String value) {
        this.resultDescription = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTransactionId(Object value) {
        this.transactionId = value;
    }

}
