package org.khmeracademy.auction;

import java.util.ArrayList;

import org.khmeracademy.auction.entities.Auction;
import org.khmeracademy.auction.entities.BidHistory;
import org.khmeracademy.auction.services.AuctionService;
import org.khmeracademy.auction.services.BidHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

	/*
	 * @Scheduled(cron="* * * * * *") public static void test() {
	 * System.out.println("HELLLO"); }
	 */

	@Autowired
	private BidHistoryService bidHistoryService;

	@Autowired
	private AuctionService auctionService;

	@Autowired
	private SmtpMailSender smtpMailSender;

	

	/**
	 * findWinner function is used to find winner who has highest bidding price
	 * and current data>= end_date of auction After found the winner, we update
	 * auction status to 2 (completed) and winner_id = user_id Finally, we send
	 * mail to inform user.
	 * 
	 * @param fixedRate
	 *            = 5000 i.e it runs every 5 seconds
	 * 
	 */
	@Scheduled(fixedRate = 5000)
	public void findWinner() {
		// call findAllBidWinnerRealTime to get list of winner
		ArrayList<BidHistory> arr = bidHistoryService.findAllBidWinnerRealTime();
		try {
			if (!arr.isEmpty()) {
				for (int i = 0; i < arr.size(); i++) {
					// get each winner to BidHistory object
					BidHistory b = arr.get(i);
					System.out.println(b.toString());

					// get auction by id
					Auction a = b.getAuction();
					System.out.println(a.toString());

					// update status and winner_id in auc_auction
					a.setStatus("3"); // completed
					a.setWinner_id(b.getUser().getUser_id());

					// call updateStatusAndWinnerIdInAuction to update and
					// return true if it is updated successfully
					boolean isUpdateSuccess = auctionService.updateStatusAndWinnerIdInAuction(a.getStatus(),
							a.getWinner_id(), a.getAuction_id());
					
					// Message is to be sent.
					String enMessage = "Congratulations! \r\n" + "Yours was the winning bid on DENH TLAI item #"
							+ a.getProduct().getProduct_id() + " for the " + a.getProduct().getProduct_name()
							+ " We are looking forward to seeing you come to HRD centre to pick up the product and pay for the item. \r\n"
							+ "Thank you for buying our item. We are delighted to be dealing with you and know you will enjoy your purchase. \r\n"
							+ "DENH TLAI - The First Cambodia Auction in Cambodia. \r\n\r\n"
							+ "Office: HRD Centre, #12, St. 323, Sangkat Beoung Kak 2, Khan Toul Kork, Phnom Penh, Cambodia. \r\n"
							+ "www.denhtlai.com";
					String khMessage = "សូមអបអរសាទរ  \r\n" + "អ្នកបាន​ ធ្វើការដេញថ្លៃដោយជោគជ័យ លើទំនិញលេខ៖⁣⁣ "
							+ a.getProduct().getProduct_id() + " សំរាប់ " + a.getProduct().getProduct_name()
							+ "។ សូមមកធ្វើការទទួលយក នូវទំនិញ⁣ និង⁣ ធ្វើការទូទាត់ប្រាក់នៅមជ្ឈមណ្ឌល HRD។ \r\n"
							+ "អរគុណដល់ការប្រើប្រាស់ជាវ⁣⁣ និង រីករាយដែលបានបំរើសេវាកម្មជូនលោកអ្នក ។\r\n\r\n"
							+ "គេហទំព័រដេញថ្លៃ⁣⁣ ដំបូងគេនៅកម្ពុជា។ " + "\r\n" + "ការិយាល័យ៖ មជ្ឈមណ្ឌល អេច អ ឌី"
							+ " ផ្ទះលេខ ១២⁣ ផ្លូវ ៣២៣ សង្កាត់បឹងកក២ ខណ្ឌទួលគោក⁣ ភ្នំពេញ។ " + "www.denhtlai.com";
					String msgBody = khMessage +"\r\n"+enMessage;
					//=============================================
					if (isUpdateSuccess) {
						System.out.println("Update Successfully");
						// send mail to inform user
						smtpMailSender.send(b.getUser().getEmail(), "Denh Tlai - The First Cambodia Auction Website",
								msgBody);						
					}

				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
