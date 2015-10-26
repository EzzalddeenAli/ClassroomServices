-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.42 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for fedena_ultimate
CREATE DATABASE IF NOT EXISTS `fedena_ultimate` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fedena_ultimate`;


-- Dumping structure for table fedena_ultimate.additional_exams
CREATE TABLE IF NOT EXISTS `additional_exams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `additional_exam_group_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `maximum_marks` int(11) DEFAULT NULL,
  `minimum_marks` int(11) DEFAULT NULL,
  `grading_level_id` int(11) DEFAULT NULL,
  `weightage` int(11) DEFAULT '0',
  `event_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.additional_exams: ~0 rows (approximately)
DELETE FROM `additional_exams`;
/*!40000 ALTER TABLE `additional_exams` DISABLE KEYS */;
/*!40000 ALTER TABLE `additional_exams` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.additional_exam_groups
CREATE TABLE IF NOT EXISTS `additional_exam_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `exam_type` varchar(255) DEFAULT NULL,
  `is_published` tinyint(1) DEFAULT '0',
  `result_published` tinyint(1) DEFAULT '0',
  `students_list` varchar(255) DEFAULT NULL,
  `exam_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.additional_exam_groups: ~0 rows (approximately)
DELETE FROM `additional_exam_groups`;
/*!40000 ALTER TABLE `additional_exam_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `additional_exam_groups` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.additional_exam_scores
CREATE TABLE IF NOT EXISTS `additional_exam_scores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `additional_exam_id` int(11) DEFAULT NULL,
  `marks` decimal(7,2) DEFAULT NULL,
  `grading_level_id` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `is_failed` tinyint(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.additional_exam_scores: ~0 rows (approximately)
DELETE FROM `additional_exam_scores`;
/*!40000 ALTER TABLE `additional_exam_scores` DISABLE KEYS */;
/*!40000 ALTER TABLE `additional_exam_scores` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.additional_fields
CREATE TABLE IF NOT EXISTS `additional_fields` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.additional_fields: ~0 rows (approximately)
DELETE FROM `additional_fields`;
/*!40000 ALTER TABLE `additional_fields` DISABLE KEYS */;
/*!40000 ALTER TABLE `additional_fields` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.apply_leaves
CREATE TABLE IF NOT EXISTS `apply_leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `employee_leave_types_id` int(11) DEFAULT NULL,
  `is_half_day` tinyint(1) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `approved` tinyint(1) DEFAULT '0',
  `viewed_by_manager` tinyint(1) DEFAULT '0',
  `manager_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.apply_leaves: ~0 rows (approximately)
DELETE FROM `apply_leaves`;
/*!40000 ALTER TABLE `apply_leaves` DISABLE KEYS */;
/*!40000 ALTER TABLE `apply_leaves` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.archived_employees
CREATE TABLE IF NOT EXISTS `archived_employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_category_id` int(11) DEFAULT NULL,
  `employee_number` varchar(255) DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  `employee_position_id` int(11) DEFAULT NULL,
  `employee_department_id` int(11) DEFAULT NULL,
  `reporting_manager_id` int(11) DEFAULT NULL,
  `employee_grade_id` int(11) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `experience_detail` text,
  `experience_year` int(11) DEFAULT NULL,
  `experience_month` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `status_description` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `marital_status` varchar(255) DEFAULT NULL,
  `children_count` int(11) DEFAULT NULL,
  `father_name` varchar(255) DEFAULT NULL,
  `mother_name` varchar(255) DEFAULT NULL,
  `husband_name` varchar(255) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `nationality_id` int(11) DEFAULT NULL,
  `home_address_line1` varchar(255) DEFAULT NULL,
  `home_address_line2` varchar(255) DEFAULT NULL,
  `home_city` varchar(255) DEFAULT NULL,
  `home_state` varchar(255) DEFAULT NULL,
  `home_country_id` int(11) DEFAULT NULL,
  `home_pin_code` varchar(255) DEFAULT NULL,
  `office_address_line1` varchar(255) DEFAULT NULL,
  `office_address_line2` varchar(255) DEFAULT NULL,
  `office_city` varchar(255) DEFAULT NULL,
  `office_state` varchar(255) DEFAULT NULL,
  `office_country_id` int(11) DEFAULT NULL,
  `office_pin_code` varchar(255) DEFAULT NULL,
  `office_phone1` varchar(255) DEFAULT NULL,
  `office_phone2` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `home_phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `photo_file_name` varchar(255) DEFAULT NULL,
  `photo_content_type` varchar(255) DEFAULT NULL,
  `photo_data` mediumblob,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `photo_file_size` int(11) DEFAULT NULL,
  `former_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.archived_employees: ~0 rows (approximately)
DELETE FROM `archived_employees`;
/*!40000 ALTER TABLE `archived_employees` DISABLE KEYS */;
/*!40000 ALTER TABLE `archived_employees` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.archived_employee_additional_details
CREATE TABLE IF NOT EXISTS `archived_employee_additional_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `additional_field_id` int(11) DEFAULT NULL,
  `additional_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.archived_employee_additional_details: ~0 rows (approximately)
DELETE FROM `archived_employee_additional_details`;
/*!40000 ALTER TABLE `archived_employee_additional_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `archived_employee_additional_details` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.archived_employee_bank_details
CREATE TABLE IF NOT EXISTS `archived_employee_bank_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `bank_field_id` int(11) DEFAULT NULL,
  `bank_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.archived_employee_bank_details: ~0 rows (approximately)
DELETE FROM `archived_employee_bank_details`;
/*!40000 ALTER TABLE `archived_employee_bank_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `archived_employee_bank_details` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.archived_employee_salary_structures
CREATE TABLE IF NOT EXISTS `archived_employee_salary_structures` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `payroll_category_id` int(11) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.archived_employee_salary_structures: ~0 rows (approximately)
DELETE FROM `archived_employee_salary_structures`;
/*!40000 ALTER TABLE `archived_employee_salary_structures` DISABLE KEYS */;
/*!40000 ALTER TABLE `archived_employee_salary_structures` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.archived_exam_scores
CREATE TABLE IF NOT EXISTS `archived_exam_scores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  `marks` decimal(7,2) DEFAULT NULL,
  `grading_level_id` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `is_failed` tinyint(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_archived_exam_scores_on_student_id_and_exam_id` (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.archived_exam_scores: ~0 rows (approximately)
DELETE FROM `archived_exam_scores`;
/*!40000 ALTER TABLE `archived_exam_scores` DISABLE KEYS */;
/*!40000 ALTER TABLE `archived_exam_scores` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.archived_guardians
CREATE TABLE IF NOT EXISTS `archived_guardians` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ward_id` int(11) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `relation` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `office_phone1` varchar(255) DEFAULT NULL,
  `office_phone2` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `office_address_line1` varchar(255) DEFAULT NULL,
  `office_address_line2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `income` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.archived_guardians: ~0 rows (approximately)
DELETE FROM `archived_guardians`;
/*!40000 ALTER TABLE `archived_guardians` DISABLE KEYS */;
/*!40000 ALTER TABLE `archived_guardians` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.archived_students
CREATE TABLE IF NOT EXISTS `archived_students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admission_no` varchar(255) DEFAULT NULL,
  `class_roll_no` varchar(255) DEFAULT NULL,
  `admission_date` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `birth_place` varchar(255) DEFAULT NULL,
  `nationality_id` int(11) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `religion` varchar(255) DEFAULT NULL,
  `student_category_id` int(11) DEFAULT NULL,
  `address_line1` varchar(255) DEFAULT NULL,
  `address_line2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `pin_code` varchar(255) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `phone1` varchar(255) DEFAULT NULL,
  `phone2` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `photo_file_name` varchar(255) DEFAULT NULL,
  `photo_content_type` varchar(255) DEFAULT NULL,
  `photo_data` mediumblob,
  `status_description` varchar(255) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `is_deleted` tinyint(1) DEFAULT '0',
  `immediate_contact_id` int(11) DEFAULT NULL,
  `is_sms_enabled` tinyint(1) DEFAULT '1',
  `former_id` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `photo_file_size` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.archived_students: ~0 rows (approximately)
DELETE FROM `archived_students`;
/*!40000 ALTER TABLE `archived_students` DISABLE KEYS */;
/*!40000 ALTER TABLE `archived_students` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.assessment_scores
CREATE TABLE IF NOT EXISTS `assessment_scores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `grade_points` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `descriptive_indicator_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `score_index` (`student_id`,`batch_id`,`descriptive_indicator_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.assessment_scores: ~0 rows (approximately)
DELETE FROM `assessment_scores`;
/*!40000 ALTER TABLE `assessment_scores` DISABLE KEYS */;
/*!40000 ALTER TABLE `assessment_scores` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.assets
CREATE TABLE IF NOT EXISTS `assets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` text,
  `amount` int(11) DEFAULT NULL,
  `is_inactive` tinyint(1) DEFAULT '0',
  `is_deleted` tinyint(1) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.assets: ~0 rows (approximately)
DELETE FROM `assets`;
/*!40000 ALTER TABLE `assets` DISABLE KEYS */;
/*!40000 ALTER TABLE `assets` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.attendances
CREATE TABLE IF NOT EXISTS `attendances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `period_table_entry_id` int(11) DEFAULT NULL,
  `forenoon` tinyint(1) DEFAULT '0',
  `afternoon` tinyint(1) DEFAULT '0',
  `reason` varchar(255) DEFAULT NULL,
  `month_date` date DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_attendances_on_month_date_and_batch_id` (`month_date`,`batch_id`),
  KEY `index_attendances_on_student_id_and_batch_id` (`student_id`,`batch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.attendances: ~0 rows (approximately)
DELETE FROM `attendances`;
/*!40000 ALTER TABLE `attendances` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendances` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.bank_fields
CREATE TABLE IF NOT EXISTS `bank_fields` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.bank_fields: ~0 rows (approximately)
DELETE FROM `bank_fields`;
/*!40000 ALTER TABLE `bank_fields` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank_fields` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.batches
CREATE TABLE IF NOT EXISTS `batches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `is_deleted` tinyint(1) DEFAULT '0',
  `employee_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_batches_on_is_deleted_and_is_active_and_course_id_and_name` (`is_deleted`,`is_active`,`course_id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.batches: ~30 rows (approximately)
DELETE FROM `batches`;
/*!40000 ALTER TABLE `batches` DISABLE KEYS */;
INSERT INTO `batches` (`id`, `name`, `course_id`, `start_date`, `end_date`, `is_active`, `is_deleted`, `employee_id`) VALUES
	(1, 'Section A', 1, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(2, 'Section B', 1, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(3, 'Section C', 1, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(4, 'Section A', 2, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(5, 'Section B', 2, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(6, 'Section C', 2, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(7, 'Section A', 3, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(8, 'Section B', 3, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(9, 'Section C', 3, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(10, 'Section A', 4, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(11, 'Section B', 4, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(12, 'Section C', 4, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(13, 'Section A', 5, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(14, 'Section B', 5, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(15, 'Section C', 5, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(16, 'Section A', 6, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(17, 'Section B', 6, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(18, 'Section C', 6, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(19, 'Section A', 7, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(20, 'Section B', 7, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(21, 'Section C', 7, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(22, 'Section A', 8, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(23, 'Section B', 8, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(24, 'Section C', 8, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(25, 'Section A', 9, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(26, 'Section B', 9, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(27, 'Section C', 9, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(28, 'Section A', 10, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(29, 'Section B', 10, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL),
	(30, 'Section C', 10, '2015-06-03 00:00:00', '2016-04-23 00:00:00', 1, 0, NULL);
/*!40000 ALTER TABLE `batches` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.batch_events
CREATE TABLE IF NOT EXISTS `batch_events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_batch_events_on_batch_id` (`batch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.batch_events: ~0 rows (approximately)
DELETE FROM `batch_events`;
/*!40000 ALTER TABLE `batch_events` DISABLE KEYS */;
/*!40000 ALTER TABLE `batch_events` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.batch_groups
CREATE TABLE IF NOT EXISTS `batch_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.batch_groups: ~0 rows (approximately)
DELETE FROM `batch_groups`;
/*!40000 ALTER TABLE `batch_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `batch_groups` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.batch_students
CREATE TABLE IF NOT EXISTS `batch_students` (
  `student_id` int(11) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  KEY `index_batch_students_on_batch_id_and_student_id` (`batch_id`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.batch_students: ~0 rows (approximately)
DELETE FROM `batch_students`;
/*!40000 ALTER TABLE `batch_students` DISABLE KEYS */;
/*!40000 ALTER TABLE `batch_students` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.cce_exam_categories
CREATE TABLE IF NOT EXISTS `cce_exam_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.cce_exam_categories: ~0 rows (approximately)
DELETE FROM `cce_exam_categories`;
/*!40000 ALTER TABLE `cce_exam_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `cce_exam_categories` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.cce_grades
CREATE TABLE IF NOT EXISTS `cce_grades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `grade_point` float DEFAULT NULL,
  `cce_grade_set_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_cce_grades_on_cce_grade_set_id` (`cce_grade_set_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.cce_grades: ~0 rows (approximately)
DELETE FROM `cce_grades`;
/*!40000 ALTER TABLE `cce_grades` DISABLE KEYS */;
/*!40000 ALTER TABLE `cce_grades` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.cce_grade_sets
CREATE TABLE IF NOT EXISTS `cce_grade_sets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.cce_grade_sets: ~0 rows (approximately)
DELETE FROM `cce_grade_sets`;
/*!40000 ALTER TABLE `cce_grade_sets` DISABLE KEYS */;
/*!40000 ALTER TABLE `cce_grade_sets` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.cce_reports
CREATE TABLE IF NOT EXISTS `cce_reports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `observable_id` int(11) DEFAULT NULL,
  `observable_type` varchar(255) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `grade_string` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cce_report_join_index` (`observable_id`,`student_id`,`batch_id`,`exam_id`,`observable_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.cce_reports: ~0 rows (approximately)
DELETE FROM `cce_reports`;
/*!40000 ALTER TABLE `cce_reports` DISABLE KEYS */;
/*!40000 ALTER TABLE `cce_reports` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.cce_weightages
CREATE TABLE IF NOT EXISTS `cce_weightages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `weightage` int(11) DEFAULT NULL,
  `criteria_type` varchar(255) DEFAULT NULL,
  `cce_exam_category_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.cce_weightages: ~0 rows (approximately)
DELETE FROM `cce_weightages`;
/*!40000 ALTER TABLE `cce_weightages` DISABLE KEYS */;
/*!40000 ALTER TABLE `cce_weightages` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.cce_weightages_courses
CREATE TABLE IF NOT EXISTS `cce_weightages_courses` (
  `cce_weightage_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  KEY `index_cce_weightages_courses_on_cce_weightage_id` (`cce_weightage_id`),
  KEY `index_cce_weightages_courses_on_course_id` (`course_id`),
  KEY `index_for_join_table_cce_weightage_courses` (`course_id`,`cce_weightage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.cce_weightages_courses: ~0 rows (approximately)
DELETE FROM `cce_weightages_courses`;
/*!40000 ALTER TABLE `cce_weightages_courses` DISABLE KEYS */;
/*!40000 ALTER TABLE `cce_weightages_courses` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.class_designations
CREATE TABLE IF NOT EXISTS `class_designations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cgpa` decimal(15,2) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `marks` decimal(15,2) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.class_designations: ~0 rows (approximately)
DELETE FROM `class_designations`;
/*!40000 ALTER TABLE `class_designations` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_designations` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.class_timings
CREATE TABLE IF NOT EXISTS `class_timings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `is_break` tinyint(1) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_class_timings_on_batch_id_and_start_time_and_end_time` (`batch_id`,`start_time`,`end_time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.class_timings: ~0 rows (approximately)
DELETE FROM `class_timings`;
/*!40000 ALTER TABLE `class_timings` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_timings` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.configurations
CREATE TABLE IF NOT EXISTS `configurations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `config_key` varchar(255) DEFAULT NULL,
  `config_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_configurations_on_config_key` (`config_key`(10)),
  KEY `index_configurations_on_config_value` (`config_value`(10))
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.configurations: ~21 rows (approximately)
DELETE FROM `configurations`;
/*!40000 ALTER TABLE `configurations` DISABLE KEYS */;
INSERT INTO `configurations` (`id`, `config_key`, `config_value`) VALUES
	(1, 'InstitutionName', ''),
	(2, 'InstitutionAddress', ''),
	(3, 'InstitutionPhoneNo', ''),
	(4, 'StudentAttendanceType', 'Daily'),
	(5, 'CurrencyType', '$'),
	(6, 'Locale', 'en'),
	(7, 'AdmissionNumberAutoIncrement', '1'),
	(8, 'EmployeeNumberAutoIncrement', '1'),
	(9, 'TotalSmsCount', '0'),
	(10, 'NetworkState', 'Online'),
	(11, 'FinancialYearStartDate', '2015-07-02'),
	(12, 'FinancialYearEndDate', '2016-07-02'),
	(13, 'AutomaticLeaveReset', '0'),
	(14, 'LeaveResetPeriod', '4'),
	(15, 'LastAutoLeaveReset', NULL),
	(16, 'GPA', '0'),
	(17, 'CWA', '0'),
	(18, 'CCE', '0'),
	(19, 'DefaultCountry', '76'),
	(20, 'AvailableModules', 'HR'),
	(21, 'AvailableModules', 'Finance');
/*!40000 ALTER TABLE `configurations` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.countries
CREATE TABLE IF NOT EXISTS `countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.countries: ~195 rows (approximately)
DELETE FROM `countries`;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` (`id`, `name`) VALUES
	(1, 'Afghanistan'),
	(2, 'Albania'),
	(3, 'Algeria'),
	(4, 'Andorra'),
	(5, 'Angola'),
	(6, 'Antigua & Deps'),
	(7, 'Argentina'),
	(8, 'Armenia'),
	(9, 'Australia'),
	(10, 'Austria'),
	(11, 'Azerbaijan'),
	(12, 'Bahamas'),
	(13, 'Bahrain'),
	(14, 'Bangladesh'),
	(15, 'Barbados'),
	(16, 'Belarus'),
	(17, 'Belgium'),
	(18, 'Belize'),
	(19, 'Benin'),
	(20, 'Bhutan'),
	(21, 'Bolivia'),
	(22, 'Bosnia Herzegovina'),
	(23, 'Botswana'),
	(24, 'Brazil'),
	(25, 'Brunei'),
	(26, 'Bulgaria'),
	(27, 'Burkina'),
	(28, 'Burundi'),
	(29, 'Cambodia'),
	(30, 'Cameroon'),
	(31, 'Canada'),
	(32, 'Cape Verde'),
	(33, 'Central African Rep'),
	(34, 'Chad'),
	(35, 'Chile'),
	(36, 'China'),
	(37, 'Colombia'),
	(38, 'Comoros'),
	(39, 'Congo'),
	(40, 'Congo {Democratic Rep}'),
	(41, 'Costa Rica'),
	(42, 'Croatia'),
	(43, 'Cuba'),
	(44, 'Cyprus'),
	(45, 'Czech Republic'),
	(46, 'Denmark'),
	(47, 'Djibouti'),
	(48, 'Dominica'),
	(49, 'Dominican Republic'),
	(50, 'East Timor'),
	(51, 'Ecuador'),
	(52, 'Egypt'),
	(53, 'El Salvador'),
	(54, 'Equatorial Guinea'),
	(55, 'Eritrea'),
	(56, 'Estonia'),
	(57, 'Ethiopia'),
	(58, 'Fiji'),
	(59, 'Finland'),
	(60, 'France'),
	(61, 'Gabon'),
	(62, 'Gambia'),
	(63, 'Georgia'),
	(64, 'Germany'),
	(65, 'Ghana'),
	(66, 'Greece'),
	(67, 'Grenada'),
	(68, 'Guatemala'),
	(69, 'Guinea'),
	(70, 'Guinea-Bissau'),
	(71, 'Guyana'),
	(72, 'Haiti'),
	(73, 'Honduras'),
	(74, 'Hungary'),
	(75, 'Iceland'),
	(76, 'India'),
	(77, 'Indonesia'),
	(78, 'Iran'),
	(79, 'Iraq'),
	(80, 'Ireland {Republic}'),
	(81, 'Israel'),
	(82, 'Italy'),
	(83, 'Ivory Coast'),
	(84, 'Jamaica'),
	(85, 'Japan'),
	(86, 'Jordan'),
	(87, 'Kazakhstan'),
	(88, 'Kenya'),
	(89, 'Kiribati'),
	(90, 'Korea North'),
	(91, 'Korea South'),
	(92, 'Kosovo'),
	(93, 'Kuwait'),
	(94, 'Kyrgyzstan'),
	(95, 'Laos'),
	(96, 'Latvia'),
	(97, 'Lebanon'),
	(98, 'Lesotho'),
	(99, 'Liberia'),
	(100, 'Libya'),
	(101, 'Liechtenstein'),
	(102, 'Lithuania'),
	(103, 'Luxembourg'),
	(104, 'Macedonia'),
	(105, 'Madagascar'),
	(106, 'Malawi'),
	(107, 'Malaysia'),
	(108, 'Maldives'),
	(109, 'Mali'),
	(110, 'Malta'),
	(111, 'Montenegro'),
	(112, 'Marshall Islands'),
	(113, 'Mauritania'),
	(114, 'Mauritius'),
	(115, 'Mexico'),
	(116, 'Micronesia'),
	(117, 'Moldova'),
	(118, 'Monaco'),
	(119, 'Mongolia'),
	(120, 'Morocco'),
	(121, 'Mozambique'),
	(122, 'Myanmar, {Burma}'),
	(123, 'Namibia'),
	(124, 'Nauru'),
	(125, 'Nepal'),
	(126, 'Netherlands'),
	(127, 'New Zealand'),
	(128, 'Nicaragua'),
	(129, 'Niger'),
	(130, 'Nigeria'),
	(131, 'Norway'),
	(132, 'Oman'),
	(133, 'Pakistan'),
	(134, 'Palau'),
	(135, 'Panama'),
	(136, 'Papua New Guinea'),
	(137, 'Paraguay'),
	(138, 'Peru'),
	(139, 'Philippines'),
	(140, 'Poland'),
	(141, 'Portugal'),
	(142, 'Qatar'),
	(143, 'Romania'),
	(144, 'Russian Federation'),
	(145, 'Rwanda'),
	(146, 'St Kitts & Nevis'),
	(147, 'St Lucia'),
	(148, 'Saint Vincent & the Grenadines'),
	(149, 'Samoa'),
	(150, 'San Marino'),
	(151, 'Sao Tome & Principe'),
	(152, 'Saudi Arabia'),
	(153, 'Senegal'),
	(154, 'Serbia'),
	(155, 'Seychelles'),
	(156, 'Sierra Leone'),
	(157, 'Singapore'),
	(158, 'Slovakia'),
	(159, 'Slovenia'),
	(160, 'Solomon Islands'),
	(161, 'Somalia'),
	(162, 'South Africa'),
	(163, 'Spain'),
	(164, 'Sri Lanka'),
	(165, 'Sudan'),
	(166, 'Suriname'),
	(167, 'Swaziland'),
	(168, 'Sweden'),
	(169, 'Switzerland'),
	(170, 'Syria'),
	(171, 'Taiwan'),
	(172, 'Tajikistan'),
	(173, 'Tanzania'),
	(174, 'Thailand'),
	(175, 'Togo'),
	(176, 'Tonga'),
	(177, 'Trinidad & Tobago'),
	(178, 'Tunisia'),
	(179, 'Turkey'),
	(180, 'Turkmenistan'),
	(181, 'Tuvalu'),
	(182, 'Uganda'),
	(183, 'Ukraine'),
	(184, 'United Arab Emirates'),
	(185, 'United Kingdom'),
	(186, 'United States'),
	(187, 'Uruguay'),
	(188, 'Uzbekistan'),
	(189, 'Vanuatu'),
	(190, 'Vatican City'),
	(191, 'Venezuea'),
	(192, 'Vietnam'),
	(193, 'Yemen'),
	(194, 'Zambia'),
	(195, 'Zimbabwe');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.courses
CREATE TABLE IF NOT EXISTS `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `section_name` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `grading_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_courses_on_grading_type` (`grading_type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.courses: ~10 rows (approximately)
DELETE FROM `courses`;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` (`id`, `course_name`, `code`, `section_name`, `is_deleted`, `created_at`, `updated_at`, `grading_type`) VALUES
	(1, '1', 'Class 1', NULL, 0, '2015-10-23 18:33:53', '2015-10-23 18:33:53', 'Percentage'),
	(2, '2', 'Class 2', NULL, 0, '2015-10-23 18:33:53', '2015-10-23 18:33:53', 'Percentage'),
	(3, '4', 'Class 4', NULL, 0, '2015-10-23 18:33:53', '2015-10-23 18:33:53', 'Percentage'),
	(4, '5', 'Class 5', NULL, 0, '2015-10-23 18:33:53', '2015-10-23 18:33:53', 'Percentage'),
	(5, '6', 'Class 6', NULL, 0, '2015-10-23 18:33:53', '2015-10-23 18:33:53', 'Percentage'),
	(6, '7', 'Class 7', NULL, 0, '2015-10-23 18:33:53', '2015-10-23 18:33:53', 'Percentage'),
	(7, '8', 'Class 8', NULL, 0, '2015-10-23 18:33:53', '2015-10-23 18:33:53', 'Percentage'),
	(8, '9', 'Class 9', NULL, 0, '2015-10-23 18:33:53', '2015-10-23 18:33:53', 'Percentage'),
	(9, '10', 'Class 10', NULL, 0, '2015-10-23 18:33:53', '2015-10-23 18:33:53', 'Percentage'),
	(10, '3', 'Class 3', NULL, 0, '2015-10-23 18:33:53', '2015-10-23 18:33:53', 'Percentage');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.courses_observation_groups
CREATE TABLE IF NOT EXISTS `courses_observation_groups` (
  `course_id` int(11) DEFAULT NULL,
  `observation_group_id` int(11) DEFAULT NULL,
  KEY `index_courses_observation_groups_on_observation_group_id` (`observation_group_id`),
  KEY `index_courses_observation_groups_on_course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.courses_observation_groups: ~0 rows (approximately)
DELETE FROM `courses_observation_groups`;
/*!40000 ALTER TABLE `courses_observation_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `courses_observation_groups` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.delayed_jobs
CREATE TABLE IF NOT EXISTS `delayed_jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `priority` int(11) DEFAULT '0',
  `attempts` int(11) DEFAULT '0',
  `handler` text,
  `last_error` text,
  `run_at` datetime DEFAULT NULL,
  `locked_at` datetime DEFAULT NULL,
  `failed_at` datetime DEFAULT NULL,
  `locked_by` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_delayed_jobs_on_locked_by` (`locked_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.delayed_jobs: ~0 rows (approximately)
DELETE FROM `delayed_jobs`;
/*!40000 ALTER TABLE `delayed_jobs` DISABLE KEYS */;
/*!40000 ALTER TABLE `delayed_jobs` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.descriptive_indicators
CREATE TABLE IF NOT EXISTS `descriptive_indicators` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `describable_id` int(11) DEFAULT NULL,
  `describable_type` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `describable_index` (`describable_id`,`describable_type`,`sort_order`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.descriptive_indicators: ~0 rows (approximately)
DELETE FROM `descriptive_indicators`;
/*!40000 ALTER TABLE `descriptive_indicators` DISABLE KEYS */;
/*!40000 ALTER TABLE `descriptive_indicators` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.electives
CREATE TABLE IF NOT EXISTS `electives` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `elective_group_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.electives: ~0 rows (approximately)
DELETE FROM `electives`;
/*!40000 ALTER TABLE `electives` DISABLE KEYS */;
/*!40000 ALTER TABLE `electives` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.elective_groups
CREATE TABLE IF NOT EXISTS `elective_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.elective_groups: ~0 rows (approximately)
DELETE FROM `elective_groups`;
/*!40000 ALTER TABLE `elective_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `elective_groups` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employees
CREATE TABLE IF NOT EXISTS `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_category_id` int(11) DEFAULT NULL,
  `employee_number` varchar(255) DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `job_title` varchar(255) DEFAULT NULL,
  `employee_position_id` int(11) DEFAULT NULL,
  `employee_department_id` int(11) DEFAULT NULL,
  `reporting_manager_id` int(11) DEFAULT NULL,
  `employee_grade_id` int(11) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `experience_detail` text,
  `experience_year` int(11) DEFAULT NULL,
  `experience_month` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `status_description` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `marital_status` varchar(255) DEFAULT NULL,
  `children_count` int(11) DEFAULT NULL,
  `father_name` varchar(255) DEFAULT NULL,
  `mother_name` varchar(255) DEFAULT NULL,
  `husband_name` varchar(255) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `nationality_id` int(11) DEFAULT NULL,
  `home_address_line1` varchar(255) DEFAULT NULL,
  `home_address_line2` varchar(255) DEFAULT NULL,
  `home_city` varchar(255) DEFAULT NULL,
  `home_state` varchar(255) DEFAULT NULL,
  `home_country_id` int(11) DEFAULT NULL,
  `home_pin_code` varchar(255) DEFAULT NULL,
  `office_address_line1` varchar(255) DEFAULT NULL,
  `office_address_line2` varchar(255) DEFAULT NULL,
  `office_city` varchar(255) DEFAULT NULL,
  `office_state` varchar(255) DEFAULT NULL,
  `office_country_id` int(11) DEFAULT NULL,
  `office_pin_code` varchar(255) DEFAULT NULL,
  `office_phone1` varchar(255) DEFAULT NULL,
  `office_phone2` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `home_phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `photo_file_name` varchar(255) DEFAULT NULL,
  `photo_content_type` varchar(255) DEFAULT NULL,
  `photo_data` mediumblob,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `photo_file_size` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_employees_on_employee_number` (`employee_number`(10))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employees: ~1 rows (approximately)
DELETE FROM `employees`;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`id`, `employee_category_id`, `employee_number`, `joining_date`, `first_name`, `middle_name`, `last_name`, `gender`, `job_title`, `employee_position_id`, `employee_department_id`, `reporting_manager_id`, `employee_grade_id`, `qualification`, `experience_detail`, `experience_year`, `experience_month`, `status`, `status_description`, `date_of_birth`, `marital_status`, `children_count`, `father_name`, `mother_name`, `husband_name`, `blood_group`, `nationality_id`, `home_address_line1`, `home_address_line2`, `home_city`, `home_state`, `home_country_id`, `home_pin_code`, `office_address_line1`, `office_address_line2`, `office_city`, `office_state`, `office_country_id`, `office_pin_code`, `office_phone1`, `office_phone2`, `mobile_phone`, `home_phone`, `email`, `fax`, `photo_file_name`, `photo_content_type`, `photo_data`, `created_at`, `updated_at`, `photo_file_size`, `user_id`) VALUES
	(1, 1, 'admin', '2015-07-02', 'Admin', NULL, 'User', NULL, NULL, 1, 1, NULL, 1, NULL, NULL, NULL, NULL, 1, NULL, '2014-07-02', NULL, NULL, NULL, NULL, NULL, NULL, 76, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'noreply@fedena.com', NULL, NULL, NULL, NULL, '2015-07-02 09:47:39', '2015-07-02 09:47:39', NULL, 1);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employees_subjects
CREATE TABLE IF NOT EXISTS `employees_subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_employees_subjects_on_subject_id` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employees_subjects: ~0 rows (approximately)
DELETE FROM `employees_subjects`;
/*!40000 ALTER TABLE `employees_subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `employees_subjects` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_additional_details
CREATE TABLE IF NOT EXISTS `employee_additional_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `additional_field_id` int(11) DEFAULT NULL,
  `additional_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_additional_details: ~0 rows (approximately)
DELETE FROM `employee_additional_details`;
/*!40000 ALTER TABLE `employee_additional_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_additional_details` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_attendances
CREATE TABLE IF NOT EXISTS `employee_attendances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance_date` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `employee_leave_type_id` int(11) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `is_half_day` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_attendances: ~0 rows (approximately)
DELETE FROM `employee_attendances`;
/*!40000 ALTER TABLE `employee_attendances` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_attendances` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_bank_details
CREATE TABLE IF NOT EXISTS `employee_bank_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `bank_field_id` int(11) DEFAULT NULL,
  `bank_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_bank_details: ~0 rows (approximately)
DELETE FROM `employee_bank_details`;
/*!40000 ALTER TABLE `employee_bank_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_bank_details` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_categories
CREATE TABLE IF NOT EXISTS `employee_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `prefix` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_categories: ~1 rows (approximately)
DELETE FROM `employee_categories`;
/*!40000 ALTER TABLE `employee_categories` DISABLE KEYS */;
INSERT INTO `employee_categories` (`id`, `name`, `prefix`, `status`) VALUES
	(1, 'System Admin', 'Admin', 1);
/*!40000 ALTER TABLE `employee_categories` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_departments
CREATE TABLE IF NOT EXISTS `employee_departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_departments: ~1 rows (approximately)
DELETE FROM `employee_departments`;
/*!40000 ALTER TABLE `employee_departments` DISABLE KEYS */;
INSERT INTO `employee_departments` (`id`, `code`, `name`, `status`) VALUES
	(1, 'Admin', 'System Admin', 1);
/*!40000 ALTER TABLE `employee_departments` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_department_events
CREATE TABLE IF NOT EXISTS `employee_department_events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) DEFAULT NULL,
  `employee_department_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_department_events: ~0 rows (approximately)
DELETE FROM `employee_department_events`;
/*!40000 ALTER TABLE `employee_department_events` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_department_events` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_grades
CREATE TABLE IF NOT EXISTS `employee_grades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `max_hours_day` int(11) DEFAULT NULL,
  `max_hours_week` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_grades: ~1 rows (approximately)
DELETE FROM `employee_grades`;
/*!40000 ALTER TABLE `employee_grades` DISABLE KEYS */;
INSERT INTO `employee_grades` (`id`, `name`, `priority`, `status`, `max_hours_day`, `max_hours_week`) VALUES
	(1, 'System Admin', 0, 1, NULL, NULL);
/*!40000 ALTER TABLE `employee_grades` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_leaves
CREATE TABLE IF NOT EXISTS `employee_leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `employee_leave_type_id` int(11) DEFAULT NULL,
  `leave_count` decimal(5,1) DEFAULT '0.0',
  `leave_taken` decimal(5,1) DEFAULT '0.0',
  `reset_date` date DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_leaves: ~0 rows (approximately)
DELETE FROM `employee_leaves`;
/*!40000 ALTER TABLE `employee_leaves` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_leaves` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_leave_types
CREATE TABLE IF NOT EXISTS `employee_leave_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `max_leave_count` varchar(255) DEFAULT NULL,
  `carry_forward` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_leave_types: ~0 rows (approximately)
DELETE FROM `employee_leave_types`;
/*!40000 ALTER TABLE `employee_leave_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_leave_types` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_positions
CREATE TABLE IF NOT EXISTS `employee_positions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `employee_category_id` int(11) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_positions: ~1 rows (approximately)
DELETE FROM `employee_positions`;
/*!40000 ALTER TABLE `employee_positions` DISABLE KEYS */;
INSERT INTO `employee_positions` (`id`, `name`, `employee_category_id`, `status`) VALUES
	(1, 'System Admin', 1, 1);
/*!40000 ALTER TABLE `employee_positions` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.employee_salary_structures
CREATE TABLE IF NOT EXISTS `employee_salary_structures` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `payroll_category_id` int(11) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.employee_salary_structures: ~0 rows (approximately)
DELETE FROM `employee_salary_structures`;
/*!40000 ALTER TABLE `employee_salary_structures` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_salary_structures` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.events
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `is_common` tinyint(1) DEFAULT '0',
  `is_holiday` tinyint(1) DEFAULT '0',
  `is_exam` tinyint(1) DEFAULT '0',
  `is_due` tinyint(1) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `origin_id` int(11) DEFAULT NULL,
  `origin_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_events_on_is_common_and_is_holiday_and_is_exam` (`is_common`,`is_holiday`,`is_exam`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.events: ~0 rows (approximately)
DELETE FROM `events`;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
/*!40000 ALTER TABLE `events` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.exams
CREATE TABLE IF NOT EXISTS `exams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_group_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `maximum_marks` decimal(10,2) DEFAULT NULL,
  `minimum_marks` decimal(10,2) DEFAULT NULL,
  `grading_level_id` int(11) DEFAULT NULL,
  `weightage` int(11) DEFAULT '0',
  `event_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_exams_on_exam_group_id_and_subject_id` (`exam_group_id`,`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.exams: ~0 rows (approximately)
DELETE FROM `exams`;
/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
/*!40000 ALTER TABLE `exams` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.exam_groups
CREATE TABLE IF NOT EXISTS `exam_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `exam_type` varchar(255) DEFAULT NULL,
  `is_published` tinyint(1) DEFAULT '0',
  `result_published` tinyint(1) DEFAULT '0',
  `exam_date` date DEFAULT NULL,
  `is_final_exam` tinyint(1) NOT NULL DEFAULT '0',
  `cce_exam_category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.exam_groups: ~0 rows (approximately)
DELETE FROM `exam_groups`;
/*!40000 ALTER TABLE `exam_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_groups` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.exam_scores
CREATE TABLE IF NOT EXISTS `exam_scores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  `marks` decimal(7,2) DEFAULT NULL,
  `grading_level_id` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `is_failed` tinyint(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_exam_scores_on_student_id_and_exam_id` (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.exam_scores: ~0 rows (approximately)
DELETE FROM `exam_scores`;
/*!40000 ALTER TABLE `exam_scores` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_scores` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.fa_criterias
CREATE TABLE IF NOT EXISTS `fa_criterias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fa_name` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `fa_group_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_fa_criterias_on_fa_group_id` (`fa_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.fa_criterias: ~0 rows (approximately)
DELETE FROM `fa_criterias`;
/*!40000 ALTER TABLE `fa_criterias` DISABLE KEYS */;
/*!40000 ALTER TABLE `fa_criterias` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.fa_groups
CREATE TABLE IF NOT EXISTS `fa_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `desc` text,
  `cce_exam_category_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `cce_grade_set_id` int(11) DEFAULT NULL,
  `max_marks` float DEFAULT '100',
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.fa_groups: ~0 rows (approximately)
DELETE FROM `fa_groups`;
/*!40000 ALTER TABLE `fa_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `fa_groups` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.fa_groups_subjects
CREATE TABLE IF NOT EXISTS `fa_groups_subjects` (
  `subject_id` int(11) DEFAULT NULL,
  `fa_group_id` int(11) DEFAULT NULL,
  KEY `index_fa_groups_subjects_on_subject_id` (`subject_id`),
  KEY `index_fa_groups_subjects_on_fa_group_id` (`fa_group_id`),
  KEY `score_index` (`fa_group_id`,`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.fa_groups_subjects: ~0 rows (approximately)
DELETE FROM `fa_groups_subjects`;
/*!40000 ALTER TABLE `fa_groups_subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `fa_groups_subjects` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.fee_collection_discounts
CREATE TABLE IF NOT EXISTS `fee_collection_discounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `receiver_id` int(11) DEFAULT NULL,
  `finance_fee_collection_id` int(11) DEFAULT NULL,
  `discount` decimal(15,2) DEFAULT NULL,
  `is_amount` tinyint(1) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.fee_collection_discounts: ~0 rows (approximately)
DELETE FROM `fee_collection_discounts`;
/*!40000 ALTER TABLE `fee_collection_discounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee_collection_discounts` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.fee_collection_particulars
CREATE TABLE IF NOT EXISTS `fee_collection_particulars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `amount` decimal(12,2) DEFAULT NULL,
  `finance_fee_collection_id` int(11) DEFAULT NULL,
  `student_category_id` int(11) DEFAULT NULL,
  `admission_no` varchar(255) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.fee_collection_particulars: ~0 rows (approximately)
DELETE FROM `fee_collection_particulars`;
/*!40000 ALTER TABLE `fee_collection_particulars` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee_collection_particulars` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.fee_discounts
CREATE TABLE IF NOT EXISTS `fee_discounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `receiver_id` int(11) DEFAULT NULL,
  `finance_fee_category_id` int(11) DEFAULT NULL,
  `discount` decimal(15,2) DEFAULT NULL,
  `is_amount` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.fee_discounts: ~0 rows (approximately)
DELETE FROM `fee_discounts`;
/*!40000 ALTER TABLE `fee_discounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee_discounts` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.finance_donations
CREATE TABLE IF NOT EXISTS `finance_donations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `donor` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `amount` decimal(15,2) DEFAULT NULL,
  `transaction_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `transaction_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.finance_donations: ~0 rows (approximately)
DELETE FROM `finance_donations`;
/*!40000 ALTER TABLE `finance_donations` DISABLE KEYS */;
/*!40000 ALTER TABLE `finance_donations` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.finance_fees
CREATE TABLE IF NOT EXISTS `finance_fees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fee_collection_id` int(11) DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `is_paid` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_finance_fees_on_fee_collection_id_and_student_id` (`fee_collection_id`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.finance_fees: ~0 rows (approximately)
DELETE FROM `finance_fees`;
/*!40000 ALTER TABLE `finance_fees` DISABLE KEYS */;
/*!40000 ALTER TABLE `finance_fees` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.finance_fee_categories
CREATE TABLE IF NOT EXISTS `finance_fee_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `batch_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `is_master` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.finance_fee_categories: ~0 rows (approximately)
DELETE FROM `finance_fee_categories`;
/*!40000 ALTER TABLE `finance_fee_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `finance_fee_categories` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.finance_fee_collections
CREATE TABLE IF NOT EXISTS `finance_fee_collections` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `fee_category_id` int(11) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_finance_fee_collections_on_fee_category_id` (`fee_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.finance_fee_collections: ~0 rows (approximately)
DELETE FROM `finance_fee_collections`;
/*!40000 ALTER TABLE `finance_fee_collections` DISABLE KEYS */;
/*!40000 ALTER TABLE `finance_fee_collections` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.finance_fee_particulars
CREATE TABLE IF NOT EXISTS `finance_fee_particulars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  `amount` decimal(15,2) DEFAULT NULL,
  `finance_fee_category_id` int(11) DEFAULT NULL,
  `student_category_id` int(11) DEFAULT NULL,
  `admission_no` varchar(255) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.finance_fee_particulars: ~0 rows (approximately)
DELETE FROM `finance_fee_particulars`;
/*!40000 ALTER TABLE `finance_fee_particulars` DISABLE KEYS */;
/*!40000 ALTER TABLE `finance_fee_particulars` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.finance_fee_structure_elements
CREATE TABLE IF NOT EXISTS `finance_fee_structure_elements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(15,2) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `student_category_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `fee_collection_id` int(11) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.finance_fee_structure_elements: ~0 rows (approximately)
DELETE FROM `finance_fee_structure_elements`;
/*!40000 ALTER TABLE `finance_fee_structure_elements` DISABLE KEYS */;
/*!40000 ALTER TABLE `finance_fee_structure_elements` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.finance_transactions
CREATE TABLE IF NOT EXISTS `finance_transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `amount` decimal(15,2) DEFAULT NULL,
  `fine_included` tinyint(1) DEFAULT '0',
  `category_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `finance_fees_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `transaction_date` date DEFAULT NULL,
  `fine_amount` decimal(10,2) DEFAULT '0.00',
  `master_transaction_id` int(11) DEFAULT '0',
  `finance_id` int(11) DEFAULT NULL,
  `finance_type` varchar(255) DEFAULT NULL,
  `payee_id` int(11) DEFAULT NULL,
  `payee_type` varchar(255) DEFAULT NULL,
  `receipt_no` varchar(255) DEFAULT NULL,
  `voucher_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.finance_transactions: ~0 rows (approximately)
DELETE FROM `finance_transactions`;
/*!40000 ALTER TABLE `finance_transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `finance_transactions` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.finance_transaction_categories
CREATE TABLE IF NOT EXISTS `finance_transaction_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_income` tinyint(1) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.finance_transaction_categories: ~3 rows (approximately)
DELETE FROM `finance_transaction_categories`;
/*!40000 ALTER TABLE `finance_transaction_categories` DISABLE KEYS */;
INSERT INTO `finance_transaction_categories` (`id`, `name`, `description`, `is_income`, `deleted`) VALUES
	(1, 'Salary', ' ', 0, 0),
	(2, 'Donation', ' ', 1, 0),
	(3, 'Fee', ' ', 1, 0);
/*!40000 ALTER TABLE `finance_transaction_categories` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.finance_transaction_triggers
CREATE TABLE IF NOT EXISTS `finance_transaction_triggers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `finance_category_id` int(11) DEFAULT NULL,
  `percentage` decimal(8,2) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.finance_transaction_triggers: ~0 rows (approximately)
DELETE FROM `finance_transaction_triggers`;
/*!40000 ALTER TABLE `finance_transaction_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `finance_transaction_triggers` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.grading_levels
CREATE TABLE IF NOT EXISTS `grading_levels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `min_score` int(11) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `credit_points` decimal(15,2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_grading_levels_on_batch_id_and_is_deleted` (`batch_id`,`is_deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.grading_levels: ~6 rows (approximately)
DELETE FROM `grading_levels`;
/*!40000 ALTER TABLE `grading_levels` DISABLE KEYS */;
INSERT INTO `grading_levels` (`id`, `name`, `batch_id`, `min_score`, `order`, `is_deleted`, `created_at`, `updated_at`, `credit_points`, `description`) VALUES
	(1, 'A', NULL, 90, NULL, 0, '2015-07-02 09:47:39', '2015-07-02 09:47:39', NULL, NULL),
	(2, 'B', NULL, 80, NULL, 0, '2015-07-02 09:47:39', '2015-07-02 09:47:39', NULL, NULL),
	(3, 'C', NULL, 70, NULL, 0, '2015-07-02 09:47:39', '2015-07-02 09:47:39', NULL, NULL),
	(4, 'D', NULL, 60, NULL, 0, '2015-07-02 09:47:39', '2015-07-02 09:47:39', NULL, NULL),
	(5, 'E', NULL, 50, NULL, 0, '2015-07-02 09:47:39', '2015-07-02 09:47:39', NULL, NULL),
	(6, 'F', NULL, 0, NULL, 0, '2015-07-02 09:47:39', '2015-07-02 09:47:39', NULL, NULL);
/*!40000 ALTER TABLE `grading_levels` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.grouped_batches
CREATE TABLE IF NOT EXISTS `grouped_batches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_group_id` int(11) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_grouped_batches_on_batch_group_id` (`batch_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.grouped_batches: ~0 rows (approximately)
DELETE FROM `grouped_batches`;
/*!40000 ALTER TABLE `grouped_batches` DISABLE KEYS */;
/*!40000 ALTER TABLE `grouped_batches` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.grouped_exams
CREATE TABLE IF NOT EXISTS `grouped_exams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_group_id` int(11) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `weightage` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_grouped_exams_on_batch_id` (`batch_id`),
  KEY `index_grouped_exams_on_batch_id_and_exam_group_id` (`batch_id`,`exam_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.grouped_exams: ~0 rows (approximately)
DELETE FROM `grouped_exams`;
/*!40000 ALTER TABLE `grouped_exams` DISABLE KEYS */;
/*!40000 ALTER TABLE `grouped_exams` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.grouped_exam_reports
CREATE TABLE IF NOT EXISTS `grouped_exam_reports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `exam_group_id` int(11) DEFAULT NULL,
  `marks` decimal(15,2) DEFAULT NULL,
  `score_type` varchar(255) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `by_batch_student_and_score_type` (`batch_id`,`student_id`,`score_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.grouped_exam_reports: ~0 rows (approximately)
DELETE FROM `grouped_exam_reports`;
/*!40000 ALTER TABLE `grouped_exam_reports` DISABLE KEYS */;
/*!40000 ALTER TABLE `grouped_exam_reports` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.guardians
CREATE TABLE IF NOT EXISTS `guardians` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ward_id` int(11) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `relation` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `office_phone1` varchar(255) DEFAULT NULL,
  `office_phone2` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `office_address_line1` varchar(255) DEFAULT NULL,
  `office_address_line2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `income` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.guardians: ~0 rows (approximately)
DELETE FROM `guardians`;
/*!40000 ALTER TABLE `guardians` DISABLE KEYS */;
/*!40000 ALTER TABLE `guardians` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.homework
CREATE TABLE IF NOT EXISTS `homework` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.homework: ~0 rows (approximately)
DELETE FROM `homework`;
/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
INSERT INTO `homework` (`id`, `subject_id`, `start_time`, `end_time`, `created_at`, `updated_at`, `batch_id`, `course_id`, `description`) VALUES
	(1, 1, '2015-10-24 14:33:53', '2015-10-23 18:00:00', '2015-10-24 14:33:53', '2015-10-24 14:33:53', 1, 2, 'Homework for batch 1'),
	(2, 1, '2015-10-24 14:33:53', '2015-10-23 18:00:00', '2015-10-24 14:33:53', '2015-10-24 14:33:53', 2, 2, 'Homework for batch 2'),
	(3, 1, '2015-10-24 14:33:53', '2015-10-23 18:00:00', '2015-10-24 14:33:53', '2015-10-24 14:33:53', 3, 2, 'Homework for batch 3'),
	(4, 1, '2015-10-24 14:33:53', '2015-10-23 18:00:00', '2015-10-24 14:33:53', '2015-10-24 14:33:53', 1, 1, 'Homework for batch 1'),
	(5, 1, '2015-10-24 14:33:53', '2015-10-23 18:00:00', '2015-10-24 14:33:53', '2015-10-24 14:33:53', 1, 1, 'homework 2'),
	(6, 1, '2015-10-24 14:33:53', '2015-10-24 14:33:53', '2015-10-24 14:33:00', '2015-10-24 14:33:00', 1, 1, 'Homework for batch new 1'),
	(7, 1, NULL, NULL, '2015-10-24 14:33:00', '2015-10-24 14:33:00', 1, 1, 'Homework for batch new 2'),
	(8, 1, '2015-10-24 14:33:00', '2015-10-24 14:33:00', '2015-10-24 14:33:00', '2015-10-24 14:33:00', 1, 1, '12334');
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.individual_payslip_categories
CREATE TABLE IF NOT EXISTS `individual_payslip_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `salary_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `is_deduction` tinyint(1) DEFAULT NULL,
  `include_every_month` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.individual_payslip_categories: ~0 rows (approximately)
DELETE FROM `individual_payslip_categories`;
/*!40000 ALTER TABLE `individual_payslip_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `individual_payslip_categories` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.liabilities
CREATE TABLE IF NOT EXISTS `liabilities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` text,
  `amount` int(11) DEFAULT NULL,
  `is_solved` tinyint(1) DEFAULT '0',
  `is_deleted` tinyint(1) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.liabilities: ~0 rows (approximately)
DELETE FROM `liabilities`;
/*!40000 ALTER TABLE `liabilities` DISABLE KEYS */;
/*!40000 ALTER TABLE `liabilities` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.monthly_payslips
CREATE TABLE IF NOT EXISTS `monthly_payslips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salary_date` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `payroll_category_id` int(11) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `is_approved` tinyint(1) NOT NULL DEFAULT '0',
  `approver_id` int(11) DEFAULT NULL,
  `is_rejected` tinyint(1) NOT NULL DEFAULT '0',
  `rejector_id` int(11) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.monthly_payslips: ~0 rows (approximately)
DELETE FROM `monthly_payslips`;
/*!40000 ALTER TABLE `monthly_payslips` DISABLE KEYS */;
/*!40000 ALTER TABLE `monthly_payslips` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.news
CREATE TABLE IF NOT EXISTS `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `author_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.news: ~0 rows (approximately)
DELETE FROM `news`;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.news_comments
CREATE TABLE IF NOT EXISTS `news_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `news_id` int(11) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `is_approved` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.news_comments: ~0 rows (approximately)
DELETE FROM `news_comments`;
/*!40000 ALTER TABLE `news_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `news_comments` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.observations
CREATE TABLE IF NOT EXISTS `observations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `observation_group_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_observations_on_observation_group_id` (`observation_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.observations: ~0 rows (approximately)
DELETE FROM `observations`;
/*!40000 ALTER TABLE `observations` DISABLE KEYS */;
/*!40000 ALTER TABLE `observations` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.observation_groups
CREATE TABLE IF NOT EXISTS `observation_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `header_name` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `cce_grade_set_id` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `observation_kind` varchar(255) DEFAULT NULL,
  `max_marks` float DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.observation_groups: ~0 rows (approximately)
DELETE FROM `observation_groups`;
/*!40000 ALTER TABLE `observation_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `observation_groups` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.payroll_categories
CREATE TABLE IF NOT EXISTS `payroll_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `percentage` float DEFAULT NULL,
  `payroll_category_id` int(11) DEFAULT NULL,
  `is_deduction` tinyint(1) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.payroll_categories: ~0 rows (approximately)
DELETE FROM `payroll_categories`;
/*!40000 ALTER TABLE `payroll_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `payroll_categories` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.period_entries
CREATE TABLE IF NOT EXISTS `period_entries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month_date` date DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `class_timing_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_period_entries_on_month_date_and_batch_id` (`month_date`,`batch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.period_entries: ~0 rows (approximately)
DELETE FROM `period_entries`;
/*!40000 ALTER TABLE `period_entries` DISABLE KEYS */;
/*!40000 ALTER TABLE `period_entries` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.previous_exam_scores
CREATE TABLE IF NOT EXISTS `previous_exam_scores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  `marks` decimal(7,2) DEFAULT NULL,
  `grading_level_id` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `is_failed` tinyint(1) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_previous_exam_scores_on_student_id_and_exam_id` (`student_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.previous_exam_scores: ~0 rows (approximately)
DELETE FROM `previous_exam_scores`;
/*!40000 ALTER TABLE `previous_exam_scores` DISABLE KEYS */;
/*!40000 ALTER TABLE `previous_exam_scores` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.privileges
CREATE TABLE IF NOT EXISTS `privileges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.privileges: ~21 rows (approximately)
DELETE FROM `privileges`;
/*!40000 ALTER TABLE `privileges` DISABLE KEYS */;
INSERT INTO `privileges` (`id`, `name`, `created_at`, `updated_at`, `description`) VALUES
	(1, 'ExaminationControl', '2015-07-02 09:47:10', '2015-07-02 09:47:10', 'examination_control_privilege'),
	(2, 'EnterResults', '2015-07-02 09:47:10', '2015-07-02 09:47:10', 'enter_results_privilege'),
	(3, 'ViewResults', '2015-07-02 09:47:10', '2015-07-02 09:47:10', 'view_results_privilege'),
	(4, 'Admission', '2015-07-02 09:47:10', '2015-07-02 09:47:10', 'admission_privilege'),
	(5, 'StudentsControl', '2015-07-02 09:47:10', '2015-07-02 09:47:10', 'students_control_privilege'),
	(6, 'ManageNews', '2015-07-02 09:47:10', '2015-07-02 09:47:10', 'manage_news_privilege'),
	(7, 'ManageTimetable', '2015-07-02 09:47:10', '2015-07-02 09:47:10', 'manage_timetable_privilege'),
	(8, 'StudentAttendanceView', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'student_attendance_view_privilege'),
	(9, 'HrBasics', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'hr_basics_privilege'),
	(10, 'AddNewBatch', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'add_new_batch_privilege'),
	(11, 'SubjectMaster', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'subject_master_privilege'),
	(12, 'EventManagement', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'event_management_privilege'),
	(13, 'GeneralSettings', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'general_settings_privilege'),
	(14, 'FinanceControl', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'finance_control_privilege'),
	(15, 'TimetableView', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'timetable_view_privilege'),
	(16, 'StudentAttendanceRegister', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'student_attendance_register_privilege'),
	(17, 'EmployeeAttendance', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'employee_attendance_privilege'),
	(18, 'PayslipPowers', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'payslip_powers_privilege'),
	(19, 'EmployeeSearch', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'employee_search_privilege'),
	(20, 'SMSManagement', '2015-07-02 09:47:11', '2015-07-02 09:47:11', 'sms_management_privilege'),
	(21, 'StudentView', '2015-07-02 09:47:34', '2015-07-02 09:47:40', 'student_view_privilege');
/*!40000 ALTER TABLE `privileges` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.privileges_users
CREATE TABLE IF NOT EXISTS `privileges_users` (
  `user_id` int(11) DEFAULT NULL,
  `privilege_id` int(11) DEFAULT NULL,
  KEY `index_privileges_users_on_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.privileges_users: ~0 rows (approximately)
DELETE FROM `privileges_users`;
/*!40000 ALTER TABLE `privileges_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `privileges_users` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.ranking_levels
CREATE TABLE IF NOT EXISTS `ranking_levels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `gpa` decimal(15,2) DEFAULT NULL,
  `marks` decimal(15,2) DEFAULT NULL,
  `subject_count` int(11) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `full_course` tinyint(1) DEFAULT '0',
  `course_id` int(11) DEFAULT NULL,
  `subject_limit_type` varchar(255) DEFAULT NULL,
  `marks_limit_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.ranking_levels: ~0 rows (approximately)
DELETE FROM `ranking_levels`;
/*!40000 ALTER TABLE `ranking_levels` DISABLE KEYS */;
/*!40000 ALTER TABLE `ranking_levels` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.reminders
CREATE TABLE IF NOT EXISTS `reminders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` int(11) DEFAULT NULL,
  `recipient` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `body` text,
  `is_read` tinyint(1) DEFAULT '0',
  `is_deleted_by_sender` tinyint(1) DEFAULT '0',
  `is_deleted_by_recipient` tinyint(1) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_reminders_on_recipient` (`recipient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.reminders: ~0 rows (approximately)
DELETE FROM `reminders`;
/*!40000 ALTER TABLE `reminders` DISABLE KEYS */;
/*!40000 ALTER TABLE `reminders` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.schema_migrations
CREATE TABLE IF NOT EXISTS `schema_migrations` (
  `version` varchar(255) NOT NULL,
  UNIQUE KEY `unique_schema_migrations` (`version`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.schema_migrations: ~159 rows (approximately)
DELETE FROM `schema_migrations`;
/*!40000 ALTER TABLE `schema_migrations` DISABLE KEYS */;
INSERT INTO `schema_migrations` (`version`) VALUES
	('20090622100004'),
	('20090622102004'),
	('20090622104053'),
	('20090622104054'),
	('20090622114927'),
	('20090622115927'),
	('20090703074822'),
	('20090706170408'),
	('20090715234257'),
	('20090715234258'),
	('20090717124241'),
	('20090717126241'),
	('20090718050113'),
	('20090718050453'),
	('20090718050921'),
	('20090718052749'),
	('20090731092833'),
	('20090818045411'),
	('20090818050018'),
	('20090904071048'),
	('20090904071548'),
	('20090904071642'),
	('20090904071905'),
	('20090904071906'),
	('20090904071907'),
	('20090904071908'),
	('20090904071909'),
	('20090910062751'),
	('20090914095002'),
	('20090914114212'),
	('20090916052300'),
	('20090917052349'),
	('20090917065256'),
	('20090924081520'),
	('20090926071527'),
	('20091009093746'),
	('20091026065251'),
	('20091202050910'),
	('20091202053600'),
	('20091202104818'),
	('20091207084711'),
	('20091207085849'),
	('20091207090412'),
	('20091217191652'),
	('20091217201118'),
	('20091224063502'),
	('20100403073735'),
	('20100403092229'),
	('20100403093355'),
	('20100412105036'),
	('20100412105116'),
	('20100422110336'),
	('20100426094532'),
	('20100429093616'),
	('20100505075459'),
	('20100515063157'),
	('20100515063814'),
	('20100520073311'),
	('20100524093457'),
	('20100525055716'),
	('20100602115152'),
	('20100604103435'),
	('20100604103916'),
	('20100604104308'),
	('20100604104759'),
	('20100609073016'),
	('20100609074544'),
	('20100730092747'),
	('20100731053458'),
	('20100731054033'),
	('20100731055437'),
	('20101209063633'),
	('20110221051223'),
	('20110510121550'),
	('20110511053223'),
	('20110516110336'),
	('20110706114907'),
	('20110711100500'),
	('20110721122326'),
	('20110728115723'),
	('20110729055539'),
	('20110730100503'),
	('20110805072425'),
	('20110810052138'),
	('20110912062640'),
	('20110928054502'),
	('20111015111840'),
	('20111020074717'),
	('20111105052819'),
	('20120321065124'),
	('20120326114112'),
	('20120404051019'),
	('20120404051814'),
	('20120404052524'),
	('20120410081920'),
	('20120413090231'),
	('20120420085643'),
	('20120421061939'),
	('20120421062319'),
	('20120421062549'),
	('20120421062750'),
	('20120421062917'),
	('20120421063035'),
	('20120423061415'),
	('20120423100037'),
	('20120424092335'),
	('20120425052412'),
	('20120427102307'),
	('20120503062405'),
	('20120503112304'),
	('20120504123001'),
	('20120507064439'),
	('20120508085619'),
	('20120510070334'),
	('20120514050238'),
	('20120514050318'),
	('20120514050339'),
	('20120514050353'),
	('20120514050415'),
	('20120514050433'),
	('20120514050455'),
	('20120514050500'),
	('20120514050522'),
	('20120514050548'),
	('20120514050603'),
	('20120514063103'),
	('20120514063142'),
	('20120516052659'),
	('20120517112833'),
	('20120517122038'),
	('20120518091221'),
	('20120521120315'),
	('20120522065318'),
	('20120522065410'),
	('20120525100324'),
	('20120528060855'),
	('20120530120325'),
	('20120602095356'),
	('20120606050404'),
	('20120606050437'),
	('20120608090107'),
	('20120608090126'),
	('20120613063621'),
	('20120613070054'),
	('20120614092829'),
	('20120615084815'),
	('20120615085346'),
	('20120615103301'),
	('20120618053150'),
	('20120618102301'),
	('20120625072331'),
	('20120625073818'),
	('20120626082424'),
	('20120702062719'),
	('20120704103545'),
	('20120706090514'),
	('20120706103712'),
	('20120710054428'),
	('20120816045034');
/*!40000 ALTER TABLE `schema_migrations` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.school_details
CREATE TABLE IF NOT EXISTS `school_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) DEFAULT NULL,
  `logo_file_name` varchar(255) DEFAULT NULL,
  `logo_content_type` varchar(255) DEFAULT NULL,
  `logo_file_size` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.school_details: ~0 rows (approximately)
DELETE FROM `school_details`;
/*!40000 ALTER TABLE `school_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `school_details` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.sms_logs
CREATE TABLE IF NOT EXISTS `sms_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(255) DEFAULT NULL,
  `gateway_response` varchar(255) DEFAULT NULL,
  `sms_message_id` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.sms_logs: ~0 rows (approximately)
DELETE FROM `sms_logs`;
/*!40000 ALTER TABLE `sms_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_logs` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.sms_messages
CREATE TABLE IF NOT EXISTS `sms_messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.sms_messages: ~0 rows (approximately)
DELETE FROM `sms_messages`;
/*!40000 ALTER TABLE `sms_messages` DISABLE KEYS */;
/*!40000 ALTER TABLE `sms_messages` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.sms_settings
CREATE TABLE IF NOT EXISTS `sms_settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `settings_key` varchar(255) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.sms_settings: ~9 rows (approximately)
DELETE FROM `sms_settings`;
/*!40000 ALTER TABLE `sms_settings` DISABLE KEYS */;
INSERT INTO `sms_settings` (`id`, `settings_key`, `is_enabled`) VALUES
	(1, 'ApplicationEnabled', 0),
	(2, 'ParentSmsEnabled', 0),
	(3, 'EmployeeSmsEnabled', 0),
	(4, 'StudentSmsEnabled', 0),
	(5, 'ResultPublishEnabled', 0),
	(6, 'StudentAdmissionEnabled', 0),
	(7, 'ExamScheduleResultEnabled', 0),
	(8, 'AttendanceEnabled', 0),
	(9, 'NewsEventsEnabled', 0);
/*!40000 ALTER TABLE `sms_settings` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.students
CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admission_no` int(11) DEFAULT NULL,
  `class_roll_no` int(11) DEFAULT NULL,
  `admission_date` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `birth_place` varchar(255) DEFAULT NULL,
  `nationality_id` int(11) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `religion` varchar(255) DEFAULT NULL,
  `student_category_id` int(11) DEFAULT NULL,
  `address_line1` varchar(255) DEFAULT NULL,
  `address_line2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `pin_code` int(11) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `phone1` int(11) DEFAULT NULL,
  `phone2` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `immediate_contact_id` int(11) DEFAULT NULL,
  `is_sms_enabled` varchar(255) DEFAULT '1',
  `photo_file_name` varchar(255) DEFAULT NULL,
  `photo_content_type` varchar(255) DEFAULT NULL,
  `photo_data` varchar(255) DEFAULT NULL,
  `status_description` varchar(255) DEFAULT NULL,
  `is_active` int(11) DEFAULT '1',
  `is_deleted` int(11) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `has_paid_fees` int(11) DEFAULT '0',
  `photo_file_size` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_students_on_admission_no` (`admission_no`),
  KEY `index_students_on_first_name_and_middle_name_and_last_name` (`first_name`(10),`middle_name`(10),`last_name`(10)),
  KEY `index_students_on_batch_id` (`batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.students: ~1 rows (approximately)
DELETE FROM `students`;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`id`, `admission_no`, `class_roll_no`, `admission_date`, `first_name`, `middle_name`, `last_name`, `batch_id`, `date_of_birth`, `gender`, `blood_group`, `birth_place`, `nationality_id`, `language`, `religion`, `student_category_id`, `address_line1`, `address_line2`, `city`, `state`, `pin_code`, `country_id`, `phone1`, `phone2`, `email`, `immediate_contact_id`, `is_sms_enabled`, `photo_file_name`, `photo_content_type`, `photo_data`, `status_description`, `is_active`, `is_deleted`, `created_at`, `updated_at`, `has_paid_fees`, `photo_file_size`, `user_id`) VALUES
	(1, 1, 1, '2015-03-07', 'John', 'Peter', 'Kelvin', 1, '2000-02-07', 'Male', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, 1, 0, NULL, NULL, 0, NULL, 1);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.students_subjects
CREATE TABLE IF NOT EXISTS `students_subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_students_subjects_on_student_id_and_subject_id` (`student_id`,`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.students_subjects: ~0 rows (approximately)
DELETE FROM `students_subjects`;
/*!40000 ALTER TABLE `students_subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `students_subjects` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.student_additional_details
CREATE TABLE IF NOT EXISTS `student_additional_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `additional_field_id` int(11) DEFAULT NULL,
  `additional_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.student_additional_details: ~0 rows (approximately)
DELETE FROM `student_additional_details`;
/*!40000 ALTER TABLE `student_additional_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_additional_details` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.student_additional_fields
CREATE TABLE IF NOT EXISTS `student_additional_fields` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.student_additional_fields: ~0 rows (approximately)
DELETE FROM `student_additional_fields`;
/*!40000 ALTER TABLE `student_additional_fields` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_additional_fields` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.student_categories
CREATE TABLE IF NOT EXISTS `student_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.student_categories: ~0 rows (approximately)
DELETE FROM `student_categories`;
/*!40000 ALTER TABLE `student_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_categories` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.student_previous_datas
CREATE TABLE IF NOT EXISTS `student_previous_datas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `total_mark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.student_previous_datas: ~0 rows (approximately)
DELETE FROM `student_previous_datas`;
/*!40000 ALTER TABLE `student_previous_datas` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_previous_datas` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.student_previous_subject_marks
CREATE TABLE IF NOT EXISTS `student_previous_subject_marks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.student_previous_subject_marks: ~0 rows (approximately)
DELETE FROM `student_previous_subject_marks`;
/*!40000 ALTER TABLE `student_previous_subject_marks` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_previous_subject_marks` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.subjects
CREATE TABLE IF NOT EXISTS `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  `no_exams` tinyint(1) DEFAULT '0',
  `max_weekly_classes` int(11) DEFAULT NULL,
  `elective_group_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `credit_hours` decimal(15,2) DEFAULT NULL,
  `prefer_consecutive` tinyint(1) DEFAULT '0',
  `amount` decimal(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_subjects_on_batch_id_and_elective_group_id_and_is_deleted` (`batch_id`,`elective_group_id`,`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.subjects: ~0 rows (approximately)
DELETE FROM `subjects`;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.subject_leaves
CREATE TABLE IF NOT EXISTS `subject_leaves` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `month_date` date DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `class_timing_id` int(11) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `batch_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_subject_leaves_on_month_date_and_subject_id_and_batch_id` (`month_date`,`subject_id`,`batch_id`),
  KEY `index_subject_leaves_on_student_id_and_batch_id` (`student_id`,`batch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.subject_leaves: ~0 rows (approximately)
DELETE FROM `subject_leaves`;
/*!40000 ALTER TABLE `subject_leaves` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_leaves` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.timetables
CREATE TABLE IF NOT EXISTS `timetables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT '0',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `by_start_and_end` (`start_date`,`end_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.timetables: ~0 rows (approximately)
DELETE FROM `timetables`;
/*!40000 ALTER TABLE `timetables` DISABLE KEYS */;
/*!40000 ALTER TABLE `timetables` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.timetable_entries
CREATE TABLE IF NOT EXISTS `timetable_entries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_id` int(11) DEFAULT NULL,
  `weekday_id` int(11) DEFAULT NULL,
  `class_timing_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `timetable_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_timetable_entries_on_timetable_id` (`timetable_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.timetable_entries: ~0 rows (approximately)
DELETE FROM `timetable_entries`;
/*!40000 ALTER TABLE `timetable_entries` DISABLE KEYS */;
/*!40000 ALTER TABLE `timetable_entries` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.time_zones
CREATE TABLE IF NOT EXISTS `time_zones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `difference_type` varchar(255) DEFAULT NULL,
  `time_difference` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.time_zones: ~31 rows (approximately)
DELETE FROM `time_zones`;
/*!40000 ALTER TABLE `time_zones` DISABLE KEYS */;
INSERT INTO `time_zones` (`id`, `name`, `code`, `difference_type`, `time_difference`, `created_at`, `updated_at`) VALUES
	(1, 'Greenwich Mean Time', 'GMT', '+', 0, '2015-07-02 09:47:35', '2015-07-02 09:47:35'),
	(2, 'European Central Time', 'ECT', '+', 3600, '2015-07-02 09:47:35', '2015-07-02 09:47:35'),
	(3, 'Eastern European Time', 'EET', '+', 7200, '2015-07-02 09:47:35', '2015-07-02 09:47:35'),
	(4, 'Arabic Standard Time', 'ART', '+', 7200, '2015-07-02 09:47:35', '2015-07-02 09:47:35'),
	(5, 'Eastern African Time', 'EAT', '+', 10800, '2015-07-02 09:47:35', '2015-07-02 09:47:35'),
	(6, 'Middle East Time', 'MET', '+', 12600, '2015-07-02 09:47:35', '2015-07-02 09:47:35'),
	(7, 'Near East Time', 'NET', '+', 14400, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(8, 'Pakistan Lahore Time', 'PLT', '+', 18000, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(9, 'Indian Standard Time', 'IST', '+', 19800, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(10, 'Bangladesh Standard Time', 'BST', '+', 21600, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(11, 'Vietnam Standard Time', 'VST', '+', 25200, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(12, 'China Taiwan Time', 'CTT', '+', 28800, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(13, 'Japan Standard Time', 'JST', '+', 32400, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(14, 'Australia Central Time', 'ACT', '+', 34200, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(15, 'Australia Eastern Time', 'AET', '+', 36000, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(16, 'Solomon Standard Time', 'SST', '+', 39600, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(17, 'New Zealand Standard Time', 'NST', '+', 43200, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(18, 'Midway Islands Time', 'MIT', '-', 39600, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(19, 'Hawaii Standard Time', 'HST', '-', 36000, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(20, 'Alaska Standard Time', 'AST', '-', 32400, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(21, 'Pacific Standard Time', 'PST', '-', 28800, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(22, 'Phoenix Standard Time', 'PNT', '-', 25200, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(23, 'Mountain Standard Time', 'MST', '-', 25200, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(24, 'Central Standard Time', 'CST', '-', 21600, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(25, 'Eastern Standard Time', 'EST', '-', 18000, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(26, 'Indiana Eastern Standard Time', 'IET', '-', 18000, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(27, 'Puerto Rico and US Virgin Islands Time', 'PRT', '-', 14400, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(28, 'Canada Newfoundland Time', 'CNT', '-', 12600, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(29, 'Argentina Standard Time', 'AGT', '-', 10800, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(30, 'Brazil Eastern Time', 'BET', '-', 10800, '2015-07-02 09:47:36', '2015-07-02 09:47:36'),
	(31, 'Central African Time', 'CAT', '-', 3600, '2015-07-02 09:47:36', '2015-07-02 09:47:36');
/*!40000 ALTER TABLE `time_zones` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.user
CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int(11) NOT NULL,
  `CustomerID` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `UserName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.user: ~1 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`UserID`, `CustomerID`, `Password`, `Status`, `UserName`) VALUES
	(1, '100', 'test', '1', 'test');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL,
  `student` tinyint(1) DEFAULT NULL,
  `employee` tinyint(1) DEFAULT NULL,
  `hashed_password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `reset_password_code` varchar(255) DEFAULT NULL,
  `reset_password_code_until` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `parent` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_users_on_username` (`username`(10))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.users: ~1 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `first_name`, `last_name`, `email`, `admin`, `student`, `employee`, `hashed_password`, `salt`, `reset_password_code`, `reset_password_code_until`, `created_at`, `updated_at`, `parent`) VALUES
	(1, 'admin', 'Admin', 'User', 'noreply@fedena.com', 1, 0, 0, 'dcd916238523cd852516b042d9fb9eac060da774', 'siEr6UvW', NULL, NULL, '2015-07-02 09:47:39', '2015-07-02 09:47:39', NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.user_detail
CREATE TABLE IF NOT EXISTS `user_detail` (
  `id` varchar(255) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `primary_phone` varchar(255) DEFAULT NULL,
  `mobile_phone_number` varchar(255) DEFAULT NULL,
  `home_phone_number` varchar(255) DEFAULT NULL,
  `work_phone_number` varchar(255) DEFAULT NULL,
  `uniquie_id` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `Gender` varchar(45) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.user_detail: ~1 rows (approximately)
DELETE FROM `user_detail`;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` (`id`, `first_name`, `middle_name`, `last_name`, `primary_phone`, `mobile_phone_number`, `home_phone_number`, `work_phone_number`, `uniquie_id`, `fax`, `Gender`, `user_id`) VALUES
	('1', 'ty', 'gh', 'yu', '12345', '45678', '6789', '34567', 'abcdefghij', NULL, NULL, NULL);
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.user_events
CREATE TABLE IF NOT EXISTS `user_events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.user_events: ~0 rows (approximately)
DELETE FROM `user_events`;
/*!40000 ALTER TABLE `user_events` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_events` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.user_profile
CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` varchar(255) NOT NULL,
  `login_token` varchar(255) DEFAULT NULL,
  `failed_login_attempts` int(11) DEFAULT NULL,
  `recover_token` varchar(255) DEFAULT NULL,
  `recover_date` timestamp NULL DEFAULT NULL,
  `user_detail_id` varchar(255) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `last_login` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.user_profile: ~0 rows (approximately)
DELETE FROM `user_profile`;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;


-- Dumping structure for table fedena_ultimate.weekdays
CREATE TABLE IF NOT EXISTS `weekdays` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_id` int(11) DEFAULT NULL,
  `weekday` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `day_of_week` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `index_weekdays_on_batch_id` (`batch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table fedena_ultimate.weekdays: ~5 rows (approximately)
DELETE FROM `weekdays`;
/*!40000 ALTER TABLE `weekdays` DISABLE KEYS */;
INSERT INTO `weekdays` (`id`, `batch_id`, `weekday`, `name`, `sort_order`, `day_of_week`, `is_deleted`) VALUES
	(1, NULL, '1', NULL, NULL, 1, 0),
	(2, NULL, '2', NULL, NULL, 2, 0),
	(3, NULL, '3', NULL, NULL, 3, 0),
	(4, NULL, '4', NULL, NULL, 4, 0),
	(5, NULL, '5', NULL, NULL, 5, 0);
/*!40000 ALTER TABLE `weekdays` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
