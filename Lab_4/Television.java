/** 
*The purpose of this class is to model a television
*Hasib Rostaiee 03/06/2020
*/

public class Television {

	private String manufacturer;	// Hold the brand name
	private  int screenSize;		// Hold the Screen Size of TV
	private boolean powerOn;			// Hold the value true if the power is on, and false if the power is off.
	private int channel;				// Hold the value of the channel which tv is showing
	private int volume;					// Hold the number value representing the loudness 
	
	/**
	 * This constructor will create instance of Television using manfacturer and sreen size information
	 * @param manufacturer
	 * @param screen_size
	 */
	public Television(String manufacturer, int screenSize) {
		this.manufacturer= manufacturer;
		this.screenSize = screenSize;
		powerOn = false;
		channel = 2;
		volume = 20;
	}
	
	/**
	 * Getter Method for Manufacturer of the Television class
	 * @return Return the name of the Manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * Getter method for screen size of the TV
	 * @return Screen Size
	 */
	public int getScreenSize() {
		return screenSize;
	}
	/**
	 * Getter Method for Channel of the Television
	 * @return channel
	 */
	public int getChannel() {
		return channel;
	}
	/**
	 * Getter Method for Channel of the Television
	 * @return Return the name of the Manufacturer
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * This method set the channel number
	 * @param channelNumber
	 */
	public void setChannel(int channelNumber) {
		this.channel = channelNumber;
	}
	
	/**
	 * This method turn the power on or off
	 */
	public void power() {
		powerOn=!powerOn;
	}
	/**
	 * This method increase the current volume
	 */
	public void increaseVolume() {
		volume++;
	}
	
	/**
	 * This method decrease the current volume
	 */
	public void decreaseVolume() {
		 volume--;
	}
}
