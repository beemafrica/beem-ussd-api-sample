using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace SMSAPI.Models
{
    public class USSDCallback
    {
        [Key]
        public Int64 id { get; set; }
        public string msisdn { get; set; }
        public string Operator { get; set; }
        public string session_id { get; set; }
        public string command { get; set; }
        public Payload payload { get; set; }
    }
    public class Payload
    {
        public string request_id { get; set; }
        public string response { get; set; }
    }
}
