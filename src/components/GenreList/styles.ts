import { StyleSheet } from 'react-native';

import { BLACK } from 'constants/colors';

export default StyleSheet.create({
  listContainer: {
    flex: 1,
    backgroundColor: 'red',
    zIndex: 9000,
  },
  genreText: {
    borderRadius: 4,
    borderWidth: 1,
    borderColor: BLACK,
    color: BLACK,
    marginHorizontal: 6,
    marginVertical: 4,
    padding: 4,
  },
});
