public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }
        @test
        public void GivenDistanceAndTime_ShouldReturnTotalFare()
        {
            InvoiceService invoiceGenerator = new InvoiceService();
            double distance = 2.0;
            int time = 5;
            double fare = invoiceGenerator.CalculateFare(distance, time);
            double expected = 25;
            Assert.AreEqual(expected, fare);
        }
        @test
        public void GivenLessDistanceAndTime_ShouldReturnMinFare()
        {
            InvoiceService invoiceGenerator = new InvoiceService();
            double distance = 0.1;
            int time = 1;
            double fare = invoiceGenerator.CalculateFare(distance, time);
            double expected = 5;
            Assert.AreEqual(expected, fare);
        }
        @test
        public void GivenMultipleRides_ShouldReturnTotalFare()
        {
            InvoiceService invoiceGenerator = new InvoiceService();
            string userId = "Rushikesh";
            Ride firstRide = new Ride(2.0, 5);
            Ride secondRide = new Ride(0.1, 1);
            List<Ride> rides = new List<Ride>{ firstRide, secondRide };
            UserAccount.AddRides(userId, rides);
            InvoiceSummary invoiceSummary =  invoiceGenerator.CalculateFare(userId);
            InvoiceSummary invoiceSummary =  invoiceGenerator.GetInvoiceSummary(userId);
            double expected = 30;
            Assert.AreEqual(expected, invoiceSummary.TotalFare);
            }
            public void GivenUSerId_ShouldReturnInvoiceSummary()
            Ride secondRide = new Ride(1, 1);
            List<Ride> rides = new List<Ride> { firstRide, secondRide };
            UserAccount.AddRides(userId, rides);
            InvoiceSummary invoiceSummary = invoiceGenerator.CalculateFare(userId);
            InvoiceSummary invoiceSummary = invoiceGenerator.GetInvoiceSummary(userId);
            InvoiceSummary expected = new InvoiceSummary
            {
                TotalNumberOfRides = 2,
            public void GivenUSerId_ShouldReturnInvoiceSummary()
            };
            object.Equals(expected, invoiceSummary);
        }

        @test
        public void GivenPremiumRide_ShouldReturnInvoiceSummary()
        {
            InvoiceService invoiceGenerator = new InvoiceService();
            string userId = "John";
            Ride firstRide = new Ride(3.0, 5, "Premium");
            Ride secondRide = new Ride(1, 1, "Normal");
            List<Ride> rides = new List<Ride> { firstRide, secondRide };
            UserAccount.AddRides(userId, rides);
            InvoiceSummary invoiceSummary = invoiceGenerator.GetInvoiceSummary(userId);
            InvoiceSummary expected = new InvoiceSummary
            {
                TotalNumberOfRides = 2,
                TotalFare = 66,
                AverageFarePerRide = 33
            };
            Assert.AreEqual(expected.TotalFare, invoiceSummary.TotalFare);
        }
    }
} 
